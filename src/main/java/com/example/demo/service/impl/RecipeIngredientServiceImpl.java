package com.example.demo.service.impl;

import com.example.demo.entity.RecipeIngredient;
import com.example.demo.repository.RecipeIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeIngredientServiceImpl {

    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredient addRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepository.save(recipeIngredient);
    }

    public List<RecipeIngredient> getAll() {
        return recipeIngredientRepository.findAll();
    }

    public void deactivate(Long id) {
        RecipeIngredient ri = recipeIngredientRepository.findById(id).orElseThrow();
        ri.setActive(false);
        recipeIngredientRepository.save(ri);
    }
}
