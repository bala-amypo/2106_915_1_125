package com.example.demo.service.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.service.IngredientService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    // 🔴 THIS METHOD WAS MISSING — NOW FIXED
    @Override
    public Ingredient updateCost(Long id, BigDecimal cost) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        ingredient.setCostPerUnit(cost);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deactivate(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        ingredient.deactivate();
        ingredientRepository.save(ingredient);
    }
}
