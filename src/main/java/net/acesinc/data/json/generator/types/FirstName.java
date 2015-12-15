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

/**
 *
 * @author andrewserff
 */
public class FirstName extends TypeHandler {
    public static final String TYPE_NAME = "firstName";
    public static final String TYPE_DISPLAY_NAME = "First Name";
    
    private String[] nameList = { "Andrew", "Bob", "Steve", "Sarah", "Tara", "Eric" };

    @Override
    public String getNextRandomValue() {
        return nameList[getRand().nextInt(0, nameList.length - 1)];
    }
    
    @Override
    public String getName() {
        return TYPE_NAME;
    }
            
}
