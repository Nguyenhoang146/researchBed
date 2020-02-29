/**************************************************************************
Copyright 2019 Vietnamese-German-University

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author: ngpbh
***************************************************************************/

package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScenarioStatusModel {
    private Integer scenario;
    private String status;
    private long executionTime;
    
    public Integer getScenario() {
        return scenario;
    }

    public void setScenario(Integer scenario) {
        this.scenario = scenario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonCreator
    public ScenarioStatusModel(
        @JsonProperty("scenario") Integer scenario, 
        @JsonProperty("status") String status,
        @JsonProperty("executionTime") long executionTime) {
        this.scenario = scenario;
        this.status = status;
        this.executionTime = executionTime;
    }

    public ScenarioStatusModel() {
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

}
