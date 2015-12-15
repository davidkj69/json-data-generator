/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.acesinc.data.json.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.acesinc.data.json.generator.config.SimulationConfig;
import net.acesinc.data.json.generator.config.JSONConfigReader;
import net.acesinc.data.json.generator.log.EventLogger;
import net.acesinc.data.json.generator.log.KafkaLogger;
import net.acesinc.data.json.generator.log.Log4JLogger;
import net.acesinc.data.json.generator.log.TranquilityLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andrewserff
 */
public class JsonDataGenerator {
	
	private static final String DEFAULT_SIMULATION_CONFIG = "defaultSimConfig.json";

    private static final Logger log = LogManager.getLogger(JsonDataGenerator.class);

    private SimulationRunner simRunner;
    private String simConfigFile;

    public JsonDataGenerator(String simConfigString) {
        simConfigFile = simConfigString;
        try {
            log.debug("Creating Simulation Runner using Simulation Config [ " + simConfigString + " ]");
            SimulationConfig simConfig = getSimConfig();
            List<EventLogger> loggers = new ArrayList<>();
            for (Map<String, Object> elProps : simConfig.getProducers()) {
                String elType = (String) elProps.get("type");
                switch (elType) {
                    case "logger": {
                        log.info("Adding Log4JLogger Producer with properties" + elProps);
                        loggers.add(new Log4JLogger(elProps));
                        break;
                    }
                    case "kafka": { 
                        log.info("Adding Kafka Producer with properties: " + elProps);
                        loggers.add(new KafkaLogger(elProps));
                        break;
                    }
                    case "tranquility": {
                        log.info("Adding Tranqulity Logger with properties: " + elProps);
                        loggers.add(new TranquilityLogger(elProps));
                        break;
                    }
                }
            }
            if (loggers.isEmpty()) {
                throw new IllegalArgumentException("You must configure at least one Producer in the Simulation Config");
            }
            simRunner = new SimulationRunner(simConfig, loggers);
        } catch (IOException ex) {
            log.error("Error getting Simulation Config [ " + simConfigString + " ]");
        }
    }

    public void startRunning() {
        simRunner.startSimulation();
    }
    public void stopRunning() {
        simRunner.stopSimulation();
    }

    private SimulationConfig getSimConfig() throws IOException {
        return JSONConfigReader.readConfig(this.getClass().getClassLoader().getResourceAsStream(simConfigFile), SimulationConfig.class);
    }

    public boolean isRunning() {
        return simRunner.isRunning();
    }

    public static void main(String[] args) {
        String simConfig = DEFAULT_SIMULATION_CONFIG;
        if (args.length > 0) {
            simConfig = args[0];
            log.info("Overriding Simulation Config file from command line to use [ " + simConfig + " ]");
        }

        final JsonDataGenerator gen = new JsonDataGenerator(simConfig);

        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                log.info("Shutdown Hook Invoked.  Shutting Down Loggers");
                gen.stopRunning();
                try {
                    mainThread.join();
                } catch (InterruptedException ex) {
                    //oh well
                }
            }
        });

        gen.startRunning();
        while (gen.isRunning()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // wakie wakie!
            }
        }

    }

    /**
     * @return the simConfigFile
     */
    public String getSimConfigFile() {
        return simConfigFile;
    }

    /**
     * @param simConfigFile the simConfigFile to set
     */
    public void setSimConfigFile(String simConfigFile) {
        this.simConfigFile = simConfigFile;
    }

}
