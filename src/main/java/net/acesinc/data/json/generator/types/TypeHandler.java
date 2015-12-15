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

import org.apache.commons.math3.random.RandomDataGenerator;

/**
 *
 * @author andrewserff
 */
public abstract class TypeHandler {
    private RandomDataGenerator rand;
    private String[] launchArguments;
    
    public TypeHandler() {
        rand = new RandomDataGenerator();
    }
    
    public abstract Object getNextRandomValue();
    public abstract String getName();
    
    /**
     * @return the rand
     */
    public RandomDataGenerator getRand() {
        return rand;
    }

    /**
     * @param rand the rand to set
     */
    public void setRand(RandomDataGenerator rand) {
        this.rand = rand;
    }

    /**
     * @return the launchArguments
     */
    public String[] getLaunchArguments() {
        return launchArguments;
    }

    /**
     * @param launchArguments the launchArguments to set
     */
    public void setLaunchArguments(String[] launchArguments) {
        this.launchArguments = launchArguments;
    }
    
    public static String stripQuotes(String s) {
        return s.replaceAll("'", "").replaceAll("\"", "").trim();
    }
}
