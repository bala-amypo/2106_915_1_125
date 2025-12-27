package com.example.demo.service.impl;

import com.example.demo.entity.RecipeIngredient;
import com.example.demo.repository.*;
import com.example.demo.service.RecipeIngredientService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;
    private final MenuItemRepository menuItemRepository;
    
    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngredientRepository,
                                     IngredientRepository ingredientRepository,
                                     MenuItemRepository menuItemRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
        this.menuItemRepository = menuItemRepository;
    }
    
    @Override
    public RecipeIngredient addIngredientToMenuItem(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepository.save(recipeIngredient);
    }
    
    @Override
    public BigDecimal getTotalQuantityOfIngredient(Long ingredientId) {
        BigDecimal total = recipeIngredientRepository.getTotalQuantityByIngredientId(ingredientId);
        return total != null ? total : BigDecimal.ZERO;
    }
    
    public Double getTotalQuantityOfIngredientAsDouble(Long ingredientId) {
        return recipeIngredientRepository.getTotalQuantityByIngredientIdAsDouble(ingredientId);
    }
}