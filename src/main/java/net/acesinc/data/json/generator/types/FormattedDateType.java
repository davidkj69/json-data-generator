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

import java.text.SimpleDateFormat;

/**
 * Type that allows you to specify what the Date output will look like
 * 
 * @author dkjerrumgaard
 *
 */
public class FormattedDateType extends BaseDateType {

    public static final String TYPE_NAME = "formatted-date";
    public static final String TYPE_DISPLAY_NAME = "Formatted Date";
    
    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        // TODO Parse out the desired format string from the first param.
        
        // Bonus points, create a formatted date type config object mapped on a JSON format
        /*
          "dates": {
        			"rand-date": "date()",
        			"min-date": "date(\"2015/03/01\")",
        			"range-date": "date(\"2015/03/01\",\"2015/03/30\")",
        			"now": "now()",
        			"nowTimestamp": "nowTimestamp()",
        			"5days-ago": "now(-5_d)",
        			"timestamp": "timestamp(\"2015/03/01\",\"2015/03/30\")"
    			   }
         */
    }

    @Override
    public String getNextRandomValue() {
    	return new SimpleDateFormat("MM/dd/yyyy").format(getRandomDate());
    }

    @Override
    public String getName() {
    	return TYPE_NAME;
    }

}
