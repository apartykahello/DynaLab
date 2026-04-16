package com.visa.dynalab.dto;

import java.time.LocalDateTime;

public class DynamicModelDto {

    private Long id;
    private String name;
    private String description;
    private String modelType;
    private String equationDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DynamicModelDto() {
    }

    public DynamicModelDto(Long id,
                           String name,
                           String description,
                           String modelType,
                           String equationDescription,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modelType = modelType;
        this.equationDescription = equationDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}