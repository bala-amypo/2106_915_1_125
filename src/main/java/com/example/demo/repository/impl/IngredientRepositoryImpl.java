package com.example.demo.repository.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    private final Map<Long, Ingredient> ingredients = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Optional<Ingredient> findByNameIgnoreCase(String name) {
        return ingredients.values().stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if (ingredient.getId() == null) {
            ingredient.setId(idGenerator.getAndIncrement());
        }
        ingredients.put(ingredient.getId(), ingredient);
        return ingredient;
    }

    @Override
    public Optional<Ingredient> findById(Long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public List<Ingredient> findAll() {
        return new ArrayList<>(ingredients.values());
    }
}