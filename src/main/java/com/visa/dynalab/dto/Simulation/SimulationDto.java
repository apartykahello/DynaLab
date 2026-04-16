package com.visa.dynalab.dto.Simulation;

import java.time.LocalDateTime;
import java.util.List;

public class SimulationDto {

    private Long id;
    private String name;
    private Double dt;
    private Integer stepsCount;
    private String status;
    private LocalDateTime createdAt;
    private Long dynamicModelId;
    private Long userId;
    private List<InitialConditionDto> initialConditions;

    public SimulationDto() {
    }

    public SimulationDto(Long id,
                         String name,
                         Double dt,
                         Integer stepsCount,
                         String status,
                         LocalDateTime createdAt,
                         Long dynamicModelId,
                         Long userId,
                         List<InitialConditionDto> initialConditions) {
        this.id = id;
        this.name = name;
        this.dt = dt;
        this.stepsCount = stepsCount;
        this.status = status;
        this.createdAt = createdAt;
        this.dynamicModelId = dynamicModelId;
        this.userId = userId;
        this.initialConditions = initialConditions;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getDynamicModelId() {
        return dynamicModelId;
    }

    public Long getUserId() {
        return userId;
    }

    public List<InitialConditionDto> getInitialConditions() {
        return initialConditions;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setDynamicModelId(Long dynamicModelId) {
        this.dynamicModelId = dynamicModelId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setInitialConditions(List<InitialConditionDto> initialConditions) {
        this.initialConditions = initialConditions;
    }
}