package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal costPerUnit;

    private boolean active = true;

    public Long getId() {
        return id;
    }

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(BigDecimal costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    // ✅ ADD THIS METHOD
    public void deactivateIngredient() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }
}
