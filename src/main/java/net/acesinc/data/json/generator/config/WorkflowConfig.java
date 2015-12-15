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

/**
 *
 * @author andrewserff
 */
public class WorkflowConfig {
    private String workflowName;
    private String workflowFilename;

    /**
     * @return the workflowName
     */
    public String getWorkflowName() {
        return workflowName;
    }

    /**
     * @param workflowName the workflowName to set
     */
    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    /**
     * @return the workflowFilename
     */
    public String getWorkflowFilename() {
        return workflowFilename;
    }

    /**
     * @param workflowFilename the workflowFilename to set
     */
    public void setWorkflowFilename(String workflowFilename) {
        this.workflowFilename = workflowFilename;
    }
}
