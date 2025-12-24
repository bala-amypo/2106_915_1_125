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

    // 🔴 REQUIRED by tests
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void deactivateItem() {
        this.active = false;
    }
}
