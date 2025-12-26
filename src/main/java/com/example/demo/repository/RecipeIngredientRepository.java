package com.example.demo.repository;

import com.example.demo.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    @Query("""
        SELECT COALESCE(SUM(ri.quantity), 0)
        FROM RecipeIngredient ri
        WHERE ri.ingredient.id = :ingredientId
        AND ri.active = true
    """)
    Double getTotalQuantityByIngredientId(@Param("ingredientId") Long ingredientId);
}
