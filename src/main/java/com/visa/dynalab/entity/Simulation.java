package com.visa.dynalab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "simulations")
public class Simulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Double dt;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer stepsCount;

    @NotBlank
    @Column(nullable = false, length = 30)
    private String status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "dynamic_model_id", nullable = false)
    private DynamicModel dynamicModel;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "simulation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InitialCondition> initialConditions = new ArrayList<>();

    @OneToMany(mappedBy = "simulation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SimulationResult> results = new ArrayList<>();

    public Simulation() {
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

    public DynamicModel getDynamicModel() {
        return dynamicModel;
    }

    public User getUser() {
        return user;
    }

    public List<InitialCondition> getInitialConditions() {
        return initialConditions;
    }

    public List<SimulationResult> getResults() {
        return results;
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

    public void setDynamicModel(DynamicModel dynamicModel) {
        this.dynamicModel = dynamicModel;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setInitialConditions(List<InitialCondition> initialConditions) {
        this.initialConditions = initialConditions;
    }

    public void setResults(List<SimulationResult> results) {
        this.results = results;
    }
}