package com.visa.dynalab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "initial_conditions")
public class InitialCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Double x0;

    @NotNull
    @Column(nullable = false)
    private Double y0;

    @ManyToOne
    @JoinColumn(name = "simulation_id", nullable = false)
    private Simulation simulation;

    public InitialCondition() {
    }

    public Long getId() {
        return id;
    }

    public Double getX0() {
        return x0;
    }

    public Double getY0() {
        return y0;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setX0(Double x0) {
        this.x0 = x0;
    }

    public void setY0(Double y0) {
        this.y0 = y0;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}