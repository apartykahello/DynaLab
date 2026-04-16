package com.visa.dynalab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "simulation_results")
public class SimulationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Double time;

    @NotNull
    @Column(nullable = false)
    private Double xValue;

    @NotNull
    @Column(nullable = false)
    private Double yValue;

    @NotNull
    @Column(nullable = false)
    private Integer stepIndex;

    @ManyToOne
    @JoinColumn(name = "simulation_id", nullable = false)
    private Simulation simulation;

    @ManyToOne
    @JoinColumn(name = "initial_condition_id", nullable = false)
    private InitialCondition initialCondition;

    public SimulationResult() {
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

    public Simulation getSimulation() {
        return simulation;
    }

    public InitialCondition getInitialCondition() {
        return initialCondition;
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

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public void setInitialCondition(InitialCondition initialCondition) {
        this.initialCondition = initialCondition;
    }
}