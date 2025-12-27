package com.example.demo.repository;

import com.example.demo.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
    List<RecipeIngredient> findByMenuItemId(Long menuItemId);
    boolean existsByMenuItemId(Long menuItemId);
    
    @Query("SELECT SUM(r.quantity) FROM RecipeIngredient r WHERE r.ingredient.id = :ingredientId")
    BigDecimal getTotalQuantityByIngredientId(Long ingredientId);
    
    @Query("SELECT COALESCE(SUM(r.quantity), 0.0) FROM RecipeIngredient r WHERE r.ingredient.id = :ingredientId")
    Double getTotalQuantityByIngredientIdAsDouble(Long ingredientId);
}