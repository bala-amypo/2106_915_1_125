package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {
    private Long id;
    private String name;
    private Boolean active = true;
    private Set<MenuItem> menuItems = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public Set<MenuItem> getMenuItems() { return menuItems; }
    public void setMenuItems(Set<MenuItem> menuItems) { this.menuItems = menuItems; }
}