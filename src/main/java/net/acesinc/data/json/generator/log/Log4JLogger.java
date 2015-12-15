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
package net.acesinc.data.json.generator.log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andrewserff
 */
public class Log4JLogger implements EventLogger {
	
	public static final String LOGGER_NAME_KEY = "logger-name";

    private static final Logger log = LogManager.getLogger(Log4JLogger.class);
    
    private ObjectMapper mapper = new ObjectMapper();
    private Logger eventLogger;
    
 
    public Log4JLogger(Map<String, Object> props) {
    	String s = (String) props.get(LOGGER_NAME_KEY);
    	
    	if (StringUtils.isNotBlank(s)) {
    		eventLogger = LogManager.getLogger(s);
    	} else {
    		eventLogger = LogManager.getLogger("data-logger");
    	}
    }

    @Override
    public void logEvent(String event) {
        try {
            Object theValue = null;
            if (event.startsWith("{")) { //plain json object = Map
                theValue = mapper.readValue(event, Map.class);
            } else if (event.startsWith("[")) { //array of json objects = List
                theValue = mapper.readValue(event, List.class);
            } else { //unknown, so leave it as the literal string
                theValue = event;
            }
            eventLogger.info(mapper.writeValueAsString(theValue));
        } catch (IOException ex) {
            log.error("Error logging event", ex);
        }
    }

    @Override
    public void shutdown() {
        //nothing to shutdown
    }

}
