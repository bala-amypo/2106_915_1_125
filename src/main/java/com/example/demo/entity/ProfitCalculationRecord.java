package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "profit_calculations")
public class ProfitCalculationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MenuItem menuItem;

    private BigDecimal totalCost;

    private Double profitMargin;

    private LocalDateTime calculatedAt;

    @PrePersist
    void onCreate() {
        calculatedAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() { return id; }
    public MenuItem getMenuItem() { return menuItem; }
    public BigDecimal getTotalCost() { return totalCost; }
    public Double getProfitMargin() { return profitMargin; }

    public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
    public void setProfitMargin(Double profitMargin) { this.profitMargin = profitMargin; }
}
