package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // ⚠️ MUST MATCH service code
    private BigDecimal price;

    private Boolean active = true;

    @ManyToMany
    private Set<Category> categories = new HashSet<>();
}
