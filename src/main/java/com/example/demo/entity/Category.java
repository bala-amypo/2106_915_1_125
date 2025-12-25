package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active;

    @ManyToMany
    private Set<MenuItem> menuItems = new HashSet<>();

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Set<MenuItem> getMenuItems() { return menuItems; }
    public void setMenuItems(HashSet<MenuItem> items) {
        this.menuItems = items;
    }
}
