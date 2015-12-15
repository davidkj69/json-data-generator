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
package net.acesinc.data.json.generator.config;

import java.util.List;
import java.util.Map;

/**
 *
 * @author andrewserff
 */
public class SimulationConfig {
    private List<WorkflowConfig> workflows;
    private List<Map<String, Object>> producers;
    
    /**
     * @return the workflows
     */
    public List<WorkflowConfig> getWorkflows() {
        return workflows;
    }

    /**
     * @param workflows the workflows to set
     */
    public void setWorkflows(List<WorkflowConfig> workflows) {
        this.workflows = workflows;
    }

    /**
     * @return the producers
     */
    public List<Map<String, Object>> getProducers() {
        return producers;
    }

    /**
     * @param producers the producers to set
     */
    public void setProducers(List<Map<String, Object>> producers) {
        this.producers = producers;
    }
}
