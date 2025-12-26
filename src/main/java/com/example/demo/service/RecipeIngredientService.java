package com.example.demo.service;

import com.example.demo.entity.RecipeIngredient;
import java.util.List;

/**
 * Service interface for managing RecipeIngredient entities.
 * Provides CRUD operations and a method to deactivate ingredients.
 */
public interface ProfitCalculationService {

    /**
     * Save a new RecipeIngredient.
     * @param ingredient the ingredient to save
     * @return the saved ingredient
     */
    RecipeIngredient saveIngredient(RecipeIngredient ingredient);

    /**
     * Get all RecipeIngredients.
     * @return list of all ingredients
     */
    List<RecipeIngredient> getAllIngredients();

    /**
     * Get a RecipeIngredient by its ID.
     * @param id the ingredient ID
     * @return the ingredient, or null if not found
     */
    RecipeIngredient getIngredientById(Long id);

    /**
     * Update an existing RecipeIngredient.
     * @param id the ID of the ingredient to update
     * @param ingredient the updated ingredient data
     * @return the updated ingredient, or null if not found
     */
    RecipeIngredient updateIngredient(Long id, RecipeIngredient ingredient);

    /**
     * Delete a RecipeIngredient by its ID.
     * @param id the ID of the ingredient to delete
     */
    void deleteIngredient(Long id);

    /**
     * Deactivate a RecipeIngredient (set active to false).
     * @param id the ID of the ingredient to deactivate
     */
    void deactivateIngredient(Long id);
}
