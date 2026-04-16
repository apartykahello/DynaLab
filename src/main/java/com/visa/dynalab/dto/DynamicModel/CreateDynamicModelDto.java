package com.visa.dynalab.dto.DynamicModel;

public class CreateDynamicModelDto {

    private String name;
    private String description;
    private String xExpression;
    private String yExpression;

    public CreateDynamicModelDto() {
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
}
