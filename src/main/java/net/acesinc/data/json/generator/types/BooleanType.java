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

import java.util.Random;

/**
 *
 * @author andrewserff
 */
public class BooleanType extends TypeHandler {
    public static final String TYPE_NAME = "boolean";
    public static final String TYPE_DISPLAY_NAME = "Boolean";

    @Override
    public Boolean getNextRandomValue() {
        return new Random().nextBoolean();
    }
    
    @Override
    public String getName() {
        return TYPE_NAME;
    }
            
}
