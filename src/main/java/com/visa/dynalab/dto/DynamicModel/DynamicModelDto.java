package com.visa.dynalab.dto.DynamicModel;

import java.time.LocalDateTime;

public class DynamicModelDto {

    private Long id;
    private String name;
    private String description;
    private String xExpression;
    private String yExpression;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DynamicModelDto() {
    }

    public DynamicModelDto(Long id,
                           String name,
                           String description,
                           String xExpression,
                           String yExpression,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.xExpression = xExpression;
        this.yExpression = yExpression;
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

    public String getXExpression() {
        return xExpression;
    }

    public String getYExpression() {
        return yExpression;
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

    public void setXExpression(String xExpression) {
        this.xExpression = xExpression;
    }

    public void setYExpression(String yExpression) {
        this.yExpression = yExpression;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}