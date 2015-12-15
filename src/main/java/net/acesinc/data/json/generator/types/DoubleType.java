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
public class DoubleType extends TypeHandler {

    public static final String TYPE_NAME = "double";
    public static final String TYPE_DISPLAY_NAME = "Double";

    private double min;
    private double max;
    private Random rand;
    private int decimalPlaces = 4;

    public DoubleType() {
        super();
        rand = new Random();
    }

    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        if (launchArguments.length == 0) {
            min = 0;
            max = Double.MAX_VALUE;
        } else if (launchArguments.length == 1) {
            //min only
            min = Double.parseDouble(launchArguments[0]);
            max = Double.MAX_VALUE;
        } else if (launchArguments.length == 2) {
            min = Double.parseDouble(launchArguments[0]);
            max = Double.parseDouble(launchArguments[1]);
        }
    }

    @Override
    public Double getNextRandomValue() {
        double range = max - min;
        double scaled = rand.nextDouble() * range;
        double shifted = scaled + min;
//        return shifted; // == (rand.nextDouble() * (max-min)) + min;
        return Double.parseDouble(String.format("%." + decimalPlaces + "f", shifted));

    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }

}
