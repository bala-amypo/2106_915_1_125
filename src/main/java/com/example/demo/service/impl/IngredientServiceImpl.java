package com.example.demo.service.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.service.IngredientService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service // 🔴 MISSING in your project
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient updateCost(Long id, BigDecimal cost) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow();
        ingredient.setCostPerUnit(cost);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deactivate(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow();
        ingredient.deactivateIngredient();
        ingredientRepository.save(ingredient);
    }
}
