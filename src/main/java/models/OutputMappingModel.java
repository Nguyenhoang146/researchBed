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

public class OutputMappingModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String contentType;
    private String content;
    private long transformationTime;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonCreator
    public OutputMappingModel(@JsonProperty("status") Integer status,
        @JsonProperty("contentType") String contentType,
        @JsonProperty("content") String content,
        @JsonProperty("transformationTime") long transformationTime) {
        this.status = status;
        this.contentType = contentType;
        this.content = content;
        this.setTransformationTime(transformationTime);
    }

    @JsonCreator
    public OutputMappingModel(@JsonProperty("status") Integer status,
        @JsonProperty("contentType") String contentType,
        @JsonProperty("content") String content) {
        this.status = status;
        this.contentType = contentType;
        this.content = content;
    }

    public OutputMappingModel() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTransformationTime() {
        return transformationTime;
    }

    public void setTransformationTime(long transformationTime) {
        this.transformationTime = transformationTime;
    }

}
