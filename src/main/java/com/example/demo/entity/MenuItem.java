package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double sellingPrice;
    private boolean active = true;

    @ManyToMany
    private Set<Category> categories;

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getSellingPrice() { return sellingPrice; }
    public boolean isActive() { return active; }
    public Set<Category> getCategories() { return categories; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSellingPrice(double sellingPrice) { this.sellingPrice = sellingPrice; }
    public void setActive(boolean active) { this.active = active; }
    public void setCategories(Set<Category> categories) { this.categories = categories; }
}
