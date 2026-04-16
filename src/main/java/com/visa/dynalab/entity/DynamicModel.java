package com.visa.dynalab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dynamic_models")
public class DynamicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @Size(max = 1000)
    @Column(length = 1000)
    private String description;

    @NotBlank
    @Size(max = 1000)
    @Column(nullable = false, length = 1000)
    private String xExpression;

    @NotBlank
    @Size(max = 1000)
    @Column(nullable = false, length = 1000)
    private String yExpression;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "dynamicModel")
    private List<Simulation> simulations = new ArrayList<>();

    public DynamicModel() {

    }

    //region Getters
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

    public List<Simulation> getSimulations() {
        return simulations;
    }
    //endregion

    //region Setters
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

    public void setSimulations(List<Simulation> simulations) {
        this.simulations = simulations;
    }
    //endregion
}