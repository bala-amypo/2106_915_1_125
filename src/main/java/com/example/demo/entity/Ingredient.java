package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double costPrice;
    private boolean active = true;

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getCostPrice() { return costPrice; }
    public boolean isActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCostPrice(double costPrice) { this.costPrice = costPrice; }
    public void setActive(boolean active) { this.active = active; }
}
