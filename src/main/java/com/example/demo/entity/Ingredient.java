package com.example.demo.entity;

import java.math.BigDecimal;

public class Ingredient {
    private String name;
    private String unit;
    private BigDecimal costPerUnit;
    private Boolean active;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public BigDecimal getCostPerUnit() { return costPerUnit; }
    public void setCostPerUnit(BigDecimal costPerUnit) { this.costPerUnit = costPerUnit; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}