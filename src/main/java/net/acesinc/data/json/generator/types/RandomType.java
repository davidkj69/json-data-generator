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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrewserff
 */
public class RandomType extends TypeHandler {

    public static final String TYPE_NAME = "random";
    public static final String TYPE_DISPLAY_NAME = "Random";

    private List<Object> typedValues;

    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        typedValues = new ArrayList<>();
        for (String s : launchArguments) {
            try {
                if (s.contains("\"") || s.contains("'")) {
                    typedValues.add(stripQuotes(s));
                } else {
                    if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")) {
                        typedValues.add(Boolean.parseBoolean(s));
                    } else if (s.contains(".")) {
                        typedValues.add(Double.parseDouble(s));
                    } else {
                        typedValues.add(Long.parseLong(s));
                    }
                }
            } catch (Throwable t) {
                //error parsing, just assume string then
                typedValues.add(stripQuotes(s));
            }
        }
    }

    @Override
    public Object getNextRandomValue() {
        return typedValues.get(getRand().nextInt(0, typedValues.size() - 1));
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }

    
}
