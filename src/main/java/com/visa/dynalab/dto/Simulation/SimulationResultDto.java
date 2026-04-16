package com.visa.dynalab.dto.Simulation;

public class SimulationResultDto {

    private Long id;
    private Double time;
    private Double xValue;
    private Double yValue;
    private Integer stepIndex;
    private Long initialConditionId;

    public SimulationResultDto() {
    }

    public SimulationResultDto(Long id,
                               Double time,
                               Double xValue,
                               Double yValue,
                               Integer stepIndex,
                               Long initialConditionId) {
        this.id = id;
        this.time = time;
        this.xValue = xValue;
        this.yValue = yValue;
        this.stepIndex = stepIndex;
        this.initialConditionId = initialConditionId;
    }

    public Long getId() {
        return id;
    }

    public Double getTime() {
        return time;
    }

    public Double getXValue() {
        return xValue;
    }

    public Double getYValue() {
        return yValue;
    }

    public Integer getStepIndex() {
        return stepIndex;
    }

    public Long getInitialConditionId() {
        return initialConditionId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public void setXValue(Double xValue) {
        this.xValue = xValue;
    }

    public void setYValue(Double yValue) {
        this.yValue = yValue;
    }

    public void setStepIndex(Integer stepIndex) {
        this.stepIndex = stepIndex;
    }

    public void setInitialConditionId(Long initialConditionId) {
        this.initialConditionId = initialConditionId;
    }
}