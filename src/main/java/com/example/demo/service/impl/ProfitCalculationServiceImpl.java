package com.example.demo.service.impl;

import com.example.demo.entity.ProfitCalculationRecord;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.ProfitCalculationRecordRepository;
import com.example.demo.repository.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class ProfitCalculationServiceImpl {
    private final MenuItemRepository menuItemRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;
    private final ProfitCalculationRecordRepository profitCalculationRecordRepository;

    @Autowired
    public ProfitCalculationServiceImpl(MenuItemRepository menuItemRepository,
                                      RecipeIngredientRepository recipeIngredientRepository,
                                      IngredientRepository ingredientRepository,
                                      ProfitCalculationRecordRepository profitCalculationRecordRepository) {
        this.menuItemRepository = menuItemRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
        this.profitCalculationRecordRepository = profitCalculationRecordRepository;
    }

    public void calculateProfit(Long menuItemId) {
        if (recipeIngredientRepository.findByMenuItemId(menuItemId).isEmpty()) {
            throw new BadRequestException("No ingredients found");
        }
    }

    public ProfitCalculationRecord getCalculationById(Long id) {
        return profitCalculationRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calculation not found"));
    }

    public List<ProfitCalculationRecord> getCalculationsForMenuItem(Long menuItemId) {
        return profitCalculationRecordRepository.findByMenuItemId(menuItemId);
    }

    public List<ProfitCalculationRecord> getAllCalculations() {
        return profitCalculationRecordRepository.findAll();
    }

    public List<ProfitCalculationRecord> findRecordsWithMarginBetween(Double min, Double max) {
        return Collections.emptyList();
    }
}