package com.example.demo.service.impl;

import com.example.demo.entity.RecipeIngredient;
import com.example.demo.repository.RecipeIngredientRepository;
import com.example.demo.service.ProfitCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfitCalculationServiceImpl implements ProfitCalculationService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    @Override
    public RecipeIngredient saveIngredient(RecipeIngredient ingredient) {
        return recipeIngredientRepository.save(ingredient);
    }

    @Override
    public List<RecipeIngredient> getAllIngredients() {
        return recipeIngredientRepository.findAll();
    }

    @Override
    public RecipeIngredient getIngredientById(Long id) {
        return recipeIngredientRepository.findById(id).orElse(null);
    }

    @Override
    public RecipeIngredient updateIngredient(Long id, RecipeIngredient ingredient) {
        RecipeIngredient existing = recipeIngredientRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(ingredient.getName());
            existing.setQuantity(ingredient.getQuantity());
            existing.setUnit(ingredient.getUnit());
            existing.setActive(ingredient.isActive());
            return recipeIngredientRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteIngredient(Long id) {
        recipeIngredientRepository.deleteById(id);
    }

    @Override
    public void deactivateIngredient(Long id) {
        RecipeIngredient existing = recipeIngredientRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setActive(false);
            recipeIngredientRepository.save(existing);
        }
    }
}
