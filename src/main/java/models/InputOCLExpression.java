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

public class InputOCLExpression implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String oclContentType;
    private String ocl;
    private String self;
    private String caller;
    private String value;
    private String target;
    
    public String getOclContentType() {
        return oclContentType;
    }

    public void setOclContentType(String oclContentType) {
        this.oclContentType = oclContentType;
    }
    
    public String getOcl() {
        return ocl;
    }

    public void setOcl(String ocl) {
        this.ocl = ocl;
    }
    
    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    
    @JsonCreator
    public InputOCLExpression(
        @JsonProperty("oclContentType") String oclContentType,
        @JsonProperty("ocl") String ocl,
        @JsonProperty("self") String self,
        @JsonProperty("caller") String caller,
        @JsonProperty("value") String value,
        @JsonProperty("target") String target) {
        this.oclContentType = oclContentType;
        this.ocl = ocl;
        this.self = self;
        this.caller = caller;
        this.value = value;
        this.target = target;
    }
    
    public InputOCLExpression() {}
}
