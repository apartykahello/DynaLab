package com.visa.dynalab.dto;

public class UpdateDynamicModelDto {

    private String name;
    private String description;
    private String modelType;
    private String equationDescription;

    public UpdateDynamicModelDto() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModelType() {
        return modelType;
    }

    public String getEquationDescription() {
        return equationDescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public void setEquationDescription(String equationDescription) {
        this.equationDescription = equationDescription;
    }
}