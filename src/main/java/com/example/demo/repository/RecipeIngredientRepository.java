package com.example.demo.repository;

import com.example.demo.entity.RecipeIngredient;
import java.util.List;

public interface RecipeIngredientRepository {
    List<RecipeIngredient> findByMenuItemId(Long menuItemId);
    boolean existsByMenuItemId(Long menuItemId);
    Double getTotalQuantityByIngredientId(Long ingredientId);
    RecipeIngredient save(RecipeIngredient recipeIngredient);
}