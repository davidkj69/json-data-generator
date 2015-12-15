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
package net.acesinc.data.json.generator.types;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author andrewserff
 */
public class CounterType extends TypeHandler {
    public static final String TYPE_NAME = "counter";
    public static final String TYPE_DISPLAY_NAME = "Counter";
    
    private String currentCounterName;
    private Map<String, Long> namedCounterMap;

    public CounterType() {
        namedCounterMap = new HashMap<>();
    }

    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        if (launchArguments.length != 1) {
            throw new IllegalArgumentException("You must specify a name for the Counter");
        }
        currentCounterName = launchArguments[0];
        if (namedCounterMap.get(currentCounterName) == null) {
            namedCounterMap.put(currentCounterName, 0l);
        }
    }
    
    @Override
    public Long getNextRandomValue() {
        Long count = namedCounterMap.get(currentCounterName);
        namedCounterMap.put(currentCounterName, count + 1);
        return count;
    }
            
    @Override
    public String getName() {
        return TYPE_NAME;
    }

}
