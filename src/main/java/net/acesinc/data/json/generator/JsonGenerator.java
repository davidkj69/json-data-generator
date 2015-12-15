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

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.acesinc.data.json.generator.config.JSONConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andrewserff
 */
public class JsonGenerator {
    
    private static final Logger log = LogManager.getLogger(JsonGenerator.class);
    
    public JsonGenerator() throws IOException {
    }
    
    public Map<String, Object> testMapGenerator(String config) throws IOException {
        Map<String, Object> props = JSONConfigReader.readConfig(this.getClass().getClassLoader().getResourceAsStream(config), Map.class);
        Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put(null, props);
        RandomJsonGenerator generator = new RandomJsonGenerator(wrapper);
        Map<String, Object> map = generator.generateJsonMap();
        return map;
    }
    public String testFlatJsonGenerator(String config) throws IOException {
        Map<String, Object> props = JSONConfigReader.readConfig(this.getClass().getClassLoader().getResourceAsStream(config), Map.class);
        Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put(null, props);
        RandomJsonGenerator generator = new RandomJsonGenerator(wrapper);
        String json = generator.generateFlattnedJson();
        return json;
    }
    public List<Map<String, Object>> testListGenerator(String config) throws IOException {
        List<Map<String, Object>> props = JSONConfigReader.readConfig(this.getClass().getClassLoader().getResourceAsStream(config), List.class);
        Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put(null, props);
        RandomJsonGenerator generator = new RandomJsonGenerator(wrapper);
        List<Map<String, Object>> list = generator.generateJsonList();
        return list;
    }
    
    public static void main(String... args) {
        String config = "config6.json";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonGenerator gen = new JsonGenerator();
            log.info("Generated json Map: " + mapper.writeValueAsString(gen.testMapGenerator(config)));
            log.info("Generated flattened json Map: " + gen.testFlatJsonGenerator(config));
            JsonGenerator gen2 = new JsonGenerator();
            log.info("Generated json List: " + gen2.testListGenerator("config3.json"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
