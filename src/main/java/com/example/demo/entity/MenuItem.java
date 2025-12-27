package com.example.demo.entity;

import java.math.BigDecimal;

public class MenuItem {
    private String name;
    private String description;
    private BigDecimal sellingPrice;
    private Boolean active;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getSellingPrice() { return sellingPrice; }
    public void setSellingPrice(BigDecimal sellingPrice) { this.sellingPrice = sellingPrice; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}