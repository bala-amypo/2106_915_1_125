package com.example.demo.service.impl;

import com.example.demo.entity.RecipeIngredient;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.RecipeIngredientRepository;
import com.example.demo.service.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;
    private final MenuItemRepository menuItemRepository;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngredientRepository,
                                     IngredientRepository ingredientRepository,
                                     MenuItemRepository menuItemRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public RecipeIngredient addIngredientToMenuItem(RecipeIngredient recipeIngredient) {
        if (recipeIngredient.getQuantity() <= 0) {
            throw new BadRequestException("Invalid quantity");
        }
        return recipeIngredientRepository.save(recipeIngredient);
    }

    @Override
    public Double getTotalQuantityOfIngredient(Long ingredientId) {
        return recipeIngredientRepository.getTotalQuantityByIngredientId(ingredientId);
    }
}