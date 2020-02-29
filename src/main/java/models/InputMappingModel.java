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

public class InputMappingModel implements Serializable, InputModel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private InputDataModel dataModel;
    private InputOCLExpression oclExpression;

    @JsonCreator
    public InputMappingModel(
        @JsonProperty("oclExpression") InputOCLExpression oclExpression,
        @JsonProperty("dataModel") InputDataModel dataModel) {
        this.setOclExpression(oclExpression);
        this.setDataModel(dataModel);
    }

    public InputMappingModel() {
    }

    @Override
    public String getContent() {
        return oclExpression.getOcl();
    }

    @Override
    public String getContentType() {
        return oclExpression.getOclContentType();
    }

    @Override
    public String getDefaultDataModelXMI() {
        return dataModel.getDm();
    }

    @Override
    public String getDefaultDataModelJSON() {
        return dataModel.getDm();
    }

    @Override
    public String getDefaultDataModelName() {
        return dataModel.getDmName();
    }

    public InputDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(InputDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public InputOCLExpression getOclExpression() {
        return oclExpression;
    }

    public void setOclExpression(InputOCLExpression oclExpression) {
        this.oclExpression = oclExpression;
    }

    @Override
    public String getSelf() {
        return oclExpression.getSelf();
    }

    @Override
    public String getCaller() {
        return oclExpression.getCaller();
    }

    @Override
    public String getValue() {
        return oclExpression.getValue();
    }

    @Override
    public String getTarget() {
        return oclExpression.getTarget();
    }

}
