package com.visa.dynalab.dto.Simulation;

public class InitialConditionDto {

    private Long id;
    private Double x0;
    private Double y0;

    public InitialConditionDto() {
    }

    public InitialConditionDto(Long id, Double x0, Double y0) {
        this.id = id;
        this.x0 = x0;
        this.y0 = y0;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setX0(Double x0) {
        this.x0 = x0;
    }

    public void setY0(Double y0) {
        this.y0 = y0;
    }
}