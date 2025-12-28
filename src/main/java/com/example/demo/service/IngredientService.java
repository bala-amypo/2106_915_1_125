package com.example.demo.service;

import com.example.demo.entity.Ingredient;
import java.util.List;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);
    Ingredient getIngredientById(Long id);
    List<Ingredient> getAllIngredients();
    Ingredient updateIngredient(Long id, Ingredient ingredient);
    void deleteIngredient(Long id);
}