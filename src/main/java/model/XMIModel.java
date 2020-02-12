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

package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("XMIModel")
public class XMIModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @JsonProperty
    private String dataModelName;
    private String dataModel;
    private String oclExpression;

    public String getDataModelName() {
        return dataModelName;
    }

    public void setDataModelName(String dataModelName) {
        this.dataModelName = dataModelName;
    }

    public String getDataModel() {
        return dataModel;
    }

    public void setDataModel(String dataModel) {
        this.dataModel = dataModel;
    }

    public String getOclExpression() {
        return oclExpression;
    }

    public void setOclExpression(String oclExpression) {
        this.oclExpression = oclExpression;
    }

    @JsonCreator
    public XMIModel(
        @JsonProperty("dataModelName") String dataModelName, 
        @JsonProperty("dataModel") String dataModel,
        @JsonProperty("oclExpression") String oclExpression) {
        super();
        this.dataModelName = dataModelName;
        this.dataModel = dataModel;
        this.oclExpression = oclExpression;
    }
    
    public XMIModel() {}
}