/**************************************************************************
Copyright 2020 Vietnamese-German-University

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


package response.sqlsi;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import models.sqlsi.LecturerModel;

public class LecturerResponse implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String content;
    private LecturerModel lecturer;
    
    public LecturerResponse() {
    }

    @JsonCreator
    public LecturerResponse(@JsonProperty("status") Integer status,
        @JsonProperty("message") String content) {
        this.setStatus(status);
        this.setContent(content);
    }

    @JsonCreator
    public LecturerResponse(@JsonProperty("status") Integer status,
        @JsonProperty("lecturer") LecturerModel objectToBeDelievered) {
        this.setStatus(status);
        this.setLecturer(objectToBeDelievered);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LecturerModel getLecturer() {
        return lecturer;
    }

    public void setLecturer(LecturerModel lecturer) {
        this.lecturer = lecturer;
    }

}
