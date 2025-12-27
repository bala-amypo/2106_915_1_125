package com.example.demo.service;

import com.example.demo.entity.Ingredient;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);
    Ingredient getIngredientById(Long id);
    Ingredient updateIngredient(Long id, Ingredient ingredient);
}