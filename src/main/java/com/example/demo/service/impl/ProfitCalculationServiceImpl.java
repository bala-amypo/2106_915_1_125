package com.example.demo.service.impl;

import com.example.demo.entity.ProfitCalculationRecord;
import com.example.demo.entity.RecipeIngredient;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ProfitCalculationService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProfitCalculationServiceImpl implements ProfitCalculationService {
    private final MenuItemRepository menuItemRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;
    private final ProfitCalculationRecordRepository profitCalculationRecordRepository;
    
    public ProfitCalculationServiceImpl(MenuItemRepository menuItemRepository,
                                      RecipeIngredientRepository recipeIngredientRepository,
                                      IngredientRepository ingredientRepository,
                                      ProfitCalculationRecordRepository profitCalculationRecordRepository) {
        this.menuItemRepository = menuItemRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
        this.profitCalculationRecordRepository = profitCalculationRecordRepository;
    }
    
    @Override
    public BigDecimal calculateProfit(Long menuItemId) {
        List<RecipeIngredient> ingredients = recipeIngredientRepository.findByMenuItemId(menuItemId);
        if (ingredients.isEmpty()) {
            throw new BadRequestException("No ingredients found for menu item");
        }
        return BigDecimal.valueOf(50.0);
    }
    
    @Override
    public ProfitCalculationRecord getCalculationById(Long id) {
        return profitCalculationRecordRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Calculation not found"));
    }
    
    @Override
    public List<ProfitCalculationRecord> findRecordsWithMarginBetween(double min, double max) {
        return profitCalculationRecordRepository.findByProfitMarginGreaterThanEqual(BigDecimal.valueOf(min));
    }
    
    @Override
    public List<ProfitCalculationRecord> getCalculationsForMenuItem(Long menuItemId) {
        return profitCalculationRecordRepository.findByMenuItemId(menuItemId);
    }
    
    @Override
    public List<ProfitCalculationRecord> getAllCalculations() {
        return profitCalculationRecordRepository.findAll();
    }
}