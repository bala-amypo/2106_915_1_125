package com.example.demo.service;

import com.example.demo.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {

    RecipeIngredient addIngredientToMenuItem(RecipeIngredient recipeIngredient);

    List<RecipeIngredient> getAllRecipeIngredients();

    RecipeIngredient getRecipeIngredientById(Long id);

    void deleteRecipeIngredient(Long id);

    void deactivateRecipeIngredient(Long id);

    Double getTotalQuantityOfIngredient(Long ingredientId);
}
