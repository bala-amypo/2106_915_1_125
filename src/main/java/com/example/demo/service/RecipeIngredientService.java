package com.example.demo.service;

import com.example.demo.entity.RecipeIngredient;
import java.math.BigDecimal;

public interface RecipeIngredientService {
    RecipeIngredient addIngredientToMenuItem(RecipeIngredient recipeIngredient);
    BigDecimal getTotalQuantityOfIngredient(Long ingredientId);
}