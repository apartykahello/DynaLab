package com.visa.dynalab.dto.Simulation;

public class UpdateSimulationDto {

    private String name;
    private Double dt;
    private Integer stepsCount;
    private String status;
    private Long dynamicModelId;

    public UpdateSimulationDto() {
    }

    public String getName() {
        return name;
    }

    public Double getDt() {
        return dt;
    }

    public Integer getStepsCount() {
        return stepsCount;
    }

    public String getStatus() {
        return status;
    }

    public Long getDynamicModelId() {
        return dynamicModelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public void setStepsCount(Integer stepsCount) {
        this.stepsCount = stepsCount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDynamicModelId(Long dynamicModelId) {
        this.dynamicModelId = dynamicModelId;
    }
}