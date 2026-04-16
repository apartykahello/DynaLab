package com.visa.dynalab.dto.Simulation;

public class CreateSimulationDto {

    private String name;
    private Double startTime;
    private Double endTime;
    private Double stepSize;
    private String status;
    private Long dynamicModelId;
    private InitialConditionDto initialCondition;

    public CreateSimulationDto() {
    }

    public String getName() {
        return name;
    }

    public Double getStartTime() {
        return startTime;
    }

    public Double getEndTime() {
        return endTime;
    }

    public Double getStepSize() {
        return stepSize;
    }

    public String getStatus() {
        return status;
    }

    public Long getDynamicModelId() {
        return dynamicModelId;
    }

    public InitialConditionDto getInitialCondition() {
        return initialCondition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }

    public void setStepSize(Double stepSize) {
        this.stepSize = stepSize;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDynamicModelId(Long dynamicModelId) {
        this.dynamicModelId = dynamicModelId;
    }

    public void setInitialCondition(InitialConditionDto initialCondition) {
        this.initialCondition = initialCondition;
    }
}