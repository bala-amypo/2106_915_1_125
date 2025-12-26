package com.example.demo.service.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.MenuItem;
import com.example.demo.entity.RecipeIngredient;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.RecipeIngredientRepository;
import com.example.demo.service.RecipeIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;
    private final MenuItemRepository menuItemRepository;

    @Override
    public RecipeIngredient addIngredientToMenuItem(RecipeIngredient ri) {

        if (ri.getQuantity() == null || ri.getQuantity() <= 0) {
            throw new BadRequestException("Quantity must be positive");
        }

        Ingredient ingredient = ingredientRepository.findById(
                ri.getIngredient().getId()
        ).orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));

        MenuItem menuItem = menuItemRepository.findById(
                ri.getMenuItem().getId()
        ).orElseThrow(() -> new ResourceNotFoundException("MenuItem not found"));

        ri.setIngredient(ingredient);
        ri.setMenuItem(menuItem);
        ri.setActive(true);

        return recipeIngredientRepository.save(ri);
    }

    @Override
    public List<RecipeIngredient> getAllRecipeIngredients() {
        return recipeIngredientRepository.findAll();
    }

    @Override
    public RecipeIngredient getRecipeIngredientById(Long id) {
        return recipeIngredientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecipeIngredient not found"));
    }

    @Override
    public void deleteRecipeIngredient(Long id) {
        RecipeIngredient ri = getRecipeIngredientById(id);
        recipeIngredientRepository.delete(ri);
    }

    @Override
    public void deactivateRecipeIngredient(Long id) {
        RecipeIngredient ri = getRecipeIngredientById(id);
        ri.setActive(false);
        recipeIngredientRepository.save(ri);
    }

    @Override
    public Double getTotalQuantityOfIngredient(Long ingredientId) {
        Double total = recipeIngredientRepository.getTotalQuantityByIngredientId(ingredientId);
        return total != null ? total : 0.0;
    }
}
