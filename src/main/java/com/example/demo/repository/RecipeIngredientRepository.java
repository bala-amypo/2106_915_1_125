package com.example.demo.repository;

import com.example.demo.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
    // Optional: Add custom queries if needed, for example:
    // List<RecipeIngredient> findByRecipeId(Long recipeId);
}
