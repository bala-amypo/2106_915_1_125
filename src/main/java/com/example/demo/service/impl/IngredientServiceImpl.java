package com.example.demo.service.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final List<Ingredient> store = new ArrayList<>();

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        store.add(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return store.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return store;
    }

    @Override
    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        return ingredient;
    }

    @Override
    public void deactivateIngredient(Long id) {
        Ingredient ingredient = getIngredientById(id);
        if (ingredient != null) {
            ingredient.deactivate();
        }
    }
}
