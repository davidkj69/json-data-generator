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
public class IntegerType extends TypeHandler {

    public static final String TYPE_NAME = "integer";
    public static final String TYPE_DISPLAY_NAME = "Integer";

    private int min;
    private int max;

    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        if (launchArguments.length == 0) {
            min = 0;
            max = Integer.MAX_VALUE;
        } else if (launchArguments.length == 1) {
            //min only
            min = Integer.parseInt(launchArguments[0]);
            max = Integer.MAX_VALUE;
        } else if (launchArguments.length == 2) {
            min = Integer.parseInt(launchArguments[0]);
            max = Integer.parseInt(launchArguments[1]);
        }
    }

    @Override
    public Integer getNextRandomValue() {
        return getRand().nextInt(min, max);
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }
}
