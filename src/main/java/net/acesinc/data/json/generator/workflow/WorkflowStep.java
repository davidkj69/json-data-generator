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
package net.acesinc.data.json.generator.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andrewserff
 */
public class WorkflowStep {
    private List<Map<String, Object>> config;
    private long duration;

    public WorkflowStep() {
        config = new ArrayList<Map<String, Object>>();
    }
    
    /**
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * @return the config
     */
    public List<Map<String, Object>> getConfig() {
        return config;
    }

    /**
     * @param config the config to set
     */
    public void setConfig(List<Map<String, Object>> config) {
        this.config = config;
    }
}
