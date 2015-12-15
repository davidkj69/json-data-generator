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
package net.acesinc.data.json.generator.utils;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import net.acesinc.data.json.generator.config.JSONConfigReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  Write a class that reads in one file and stores the values in a Map<String, Array[]> structure
 * Then at runtime we can just give the key and get back the raw JSON
 *
 *  i.e.  "address" : "dictionary([address])",
 *        "state" : "dictionary([state])"
 *  
 * @author dkjerrumgaard
 *
 */
public class JsonDictionary {
	
	private static final Logger log = LogManager.getLogger(JsonDictionary.class);
	private static JsonDictionary instance;
	private Map<String, List<String>> objectMap;
	private String dictionaryFileName = "data/Dictionary.json";
	
	public static JsonDictionary getInstance() {
		if (instance == null) {
			instance = new JsonDictionary(); 
		}
		
		return instance;
	}
	
	public JsonDictionary() {
		objectMap = fromJson(dictionaryFileName);
	}
	
	public Map<String, List<String>> getDictionary() {
		return objectMap;
	}

	/**
	 * Create a String representation of the Configuration 
	 * @param o
	 * @return
	 */
	public String toJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            log.warn("Error parsing object into json", ex);
        }
        return json;
    }
	
	/**
	 * Read dictionary configuration from a file
	 * 
	 * @param fileName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,List<String>> fromJson(String fileName) {
		try {
			return JSONConfigReader.readConfig(this.getClass().getClassLoader().getResourceAsStream(fileName), Map.class);
		} catch (IOException ex) {
			log.error("Unable to read file", ex);
		}
		return null;
	}
}
