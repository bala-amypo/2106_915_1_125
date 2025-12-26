package com.example.demo.service;

import com.example.demo.entity.Ingredient;
import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long id);
    Ingredient saveIngredient(Ingredient ingredient);
    void deactivateIngredient(Long id);
}
