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
package net.acesinc.data.json.generator.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andrewserff
 */
public class JSONConfigReader {
    private static final Logger log = LogManager.getLogger(JSONConfigReader.class);
    
    public static String getJsonConfig(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            log.warn("Error parsing object into json", ex);
        }
        return json;
    }
    
    public static <T> T readConfig(File input, Class<T> targetClass) throws IOException {
        return readConfig(new FileInputStream(input), targetClass);
    }
    
    public static <T> T readConfig(InputStream input, Class<T> targetClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(input, targetClass);
    }
}
