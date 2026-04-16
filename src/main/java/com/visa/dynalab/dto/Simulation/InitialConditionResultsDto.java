package com.visa.dynalab.dto.Simulation;

import java.util.List;

public class InitialConditionResultsDto {

    private Long initialConditionId;
    private Double x0;
    private Double y0;
    private List<SimulationResultDto> results;

    public InitialConditionResultsDto() {
    }

    public InitialConditionResultsDto(Long initialConditionId,
                                      Double x0,
                                      Double y0,
                                      List<SimulationResultDto> results) {
        this.initialConditionId = initialConditionId;
        this.x0 = x0;
        this.y0 = y0;
        this.results = results;
    }

    public Long getInitialConditionId() {
        return initialConditionId;
    }

    public Double getX0() {
        return x0;
    }

    public Double getY0() {
        return y0;
    }

    public List<SimulationResultDto> getResults() {
        return results;
    }

    public void setInitialConditionId(Long initialConditionId) {
        this.initialConditionId = initialConditionId;
    }

    public void setX0(Double x0) {
        this.x0 = x0;
    }

    public void setY0(Double y0) {
        this.y0 = y0;
    }

    public void setResults(List<SimulationResultDto> results) {
        this.results = results;
    }
}