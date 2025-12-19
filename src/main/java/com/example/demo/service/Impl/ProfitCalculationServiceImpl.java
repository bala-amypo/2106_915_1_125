package com.example.demo.service.impl;

import com.example.demo.entity.MenuItem;
import com.example.demo.entity.RecipeIngredient;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.RecipeIngredientRepository;
import com.example.demo.service.ProfitCalculationService;

import java.util.List;

public class ProfitCalculationServiceImpl implements ProfitCalculationService {

    private final MenuItemRepository menuItemRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;

    public ProfitCalculationServiceImpl(MenuItemRepository menuItemRepository,
                                        RecipeIngredientRepository recipeIngredientRepository) {
        this.menuItemRepository = menuItemRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    @Override
    public Double calculateProfitForMenuItem(Long menuItemId) {

        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));

        List<RecipeIngredient> ingredients =
                recipeIngredientRepository.findByMenuItemId(menuItemId);

        double totalCost = 0.0;
        for (RecipeIngredient ri : ingredients) {
            totalCost += ri.getQuantityRequired() * ri.getIngredient().getCostPerUnit();
        }

        return menuItem.getSellingPrice().doubleValue() - totalCost;
    }
}