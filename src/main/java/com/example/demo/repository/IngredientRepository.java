package com.example.demo.repository;

import com.example.demo.entity.Ingredient;
import java.util.List;
import java.util.Optional;

public interface IngredientRepository {
    Optional<Ingredient> findByNameIgnoreCase(String name);
    Ingredient save(Ingredient ingredient);
    Optional<Ingredient> findById(Long id);
    List<Ingredient> findAll();
}