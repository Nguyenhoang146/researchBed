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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputDataModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String dmContentType;
    private String dm;
    private String dmName;
    
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }
    
    public String getDmContentType() {
        return dmContentType;
    }

    public void setDmContentType(String dmContentType) {
        this.dmContentType = dmContentType;
    }

    public String getDmName() {
        return dmName;
    }

    public void setDmName(String dmName) {
        this.dmName = dmName;
    }
    
    @JsonCreator
    public InputDataModel(
        @JsonProperty("dmContentType") String dmContentType,
        @JsonProperty("dm") String dm,
        @JsonProperty("dmName") String dmName) {
        this.dmContentType = dmContentType;
        this.dm = dm;
        this.dmName = dmName;
    }
    
    public InputDataModel() {}
}
