package com.example.demo.service;

import com.example.demo.entity.Ingredient;
import java.math.BigDecimal;

public interface IngredientService {

    Ingredient updateCost(Long id, BigDecimal cost);

    void deactivate(Long id);
}
