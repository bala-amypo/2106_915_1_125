package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal sellingPrice;

    private boolean active = true;

    // 🔴 REQUIRED by services
    public Long getId() {
        return id;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    // 🔴 REQUIRED by services
    public void deactivate() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }
}
