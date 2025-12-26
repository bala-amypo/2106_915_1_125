package com.example.demo.repository.impl;

import com.example.demo.entity.RecipeIngredient;
import com.example.demo.repository.RecipeIngredientRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RecipeIngredientRepositoryImpl implements RecipeIngredientRepository {
    private final Map<Long, RecipeIngredient> recipeIngredients = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<RecipeIngredient> findByMenuItemId(Long menuItemId) {
        return recipeIngredients.values().stream()
                .filter(ri -> ri.getMenuItem() != null && ri.getMenuItem().getId().equals(menuItemId))
                .toList();
    }

    @Override
    public boolean existsByMenuItemId(Long menuItemId) {
        return recipeIngredients.values().stream()
                .anyMatch(ri -> ri.getMenuItem() != null && ri.getMenuItem().getId().equals(menuItemId));
    }

    @Override
    public Double getTotalQuantityByIngredientId(Long ingredientId) {
        return recipeIngredients.values().stream()
                .filter(ri -> ri.getIngredient() != null && ri.getIngredient().getId().equals(ingredientId))
                .mapToDouble(RecipeIngredient::getQuantity)
                .sum();
    }

    @Override
    public RecipeIngredient save(RecipeIngredient recipeIngredient) {
        if (recipeIngredient.getId() == null) {
            recipeIngredient.setId(idGenerator.getAndIncrement());
        }
        recipeIngredients.put(recipeIngredient.getId(), recipeIngredient);
        return recipeIngredient;
    }
}