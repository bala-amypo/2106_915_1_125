package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
