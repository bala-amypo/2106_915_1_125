package com.example.demo.service.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.MenuItem;
import com.example.demo.entity.ProfitCalculationRecord;
import com.example.demo.entity.RecipeIngredient;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.ProfitCalculationRecordRepository;
import com.example.demo.repository.RecipeIngredientRepository;
import com.example.demo.service.ProfitCalculationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProfitCalculationServiceImpl implements ProfitCalculationService {

    private final MenuItemRepository menuItemRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;
    private final ProfitCalculationRecordRepository profitRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public ProfitCalculationServiceImpl(MenuItemRepository menuItemRepository,
                                        RecipeIngredientRepository recipeIngredientRepository,
                                        IngredientRepository ingredientRepository,
                                        ProfitCalculationRecordRepository profitRepo) {
        this.menuItemRepository = menuItemRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
        this.profitRepo = profitRepo;
    }

    @Override
    public ProfitCalculationRecord calculateProfit(Long menuItemId) {

        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));

        List<RecipeIngredient> ingredients =
                recipeIngredientRepository.findByMenuItemId(menuItemId);

        if (ingredients.isEmpty()) {
            throw new BadRequestException("No recipe ingredients found");
        }

        BigDecimal totalCost = BigDecimal.ZERO;

        for (RecipeIngredient ri : ingredients) {
            Ingredient ingredient = ingredientRepository.findById(
                    ri.getIngredient().getId()
            ).orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));

            BigDecimal cost = ingredient.getCostPerUnit()
                    .multiply(BigDecimal.valueOf(ri.getQuantityRequired()));

            totalCost = totalCost.add(cost);
        }

        BigDecimal sellingPrice = menuItem.getSellingPrice();
        double profitMargin =
                sellingPrice.subtract(totalCost).doubleValue();

        ProfitCalculationRecord record = new ProfitCalculationRecord();
        record.setMenuItem(menuItem);
        record.setTotalCost(totalCost);
        record.setProfitMargin(profitMargin);

        return profitRepo.save(record);
    }

    @Override
    public ProfitCalculationRecord getCalculationById(Long id) {
        return profitRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calculation not found"));
    }

    @Override
    public List<ProfitCalculationRecord> getCalculationsForMenuItem(Long menuItemId) {
        return profitRepo.findByMenuItemId(menuItemId);
    }

    @Override
    public List<ProfitCalculationRecord> getAllCalculations() {
        return profitRepo.findAll();
    }

    /**
     * Used by advanced tests with spy + criteria API
     */
    @Override
    public List<ProfitCalculationRecord> findRecordsWithMarginBetween(Double min, Double max) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProfitCalculationRecord> cq =
                cb.createQuery(ProfitCalculationRecord.class);

        Root<ProfitCalculationRecord> root = cq.from(ProfitCalculationRecord.class);

        Predicate predicate = cb.between(
                root.get("profitMargin"), min, max);

        cq.where(predicate);

        return entityManager.createQuery(cq).getResultList();
    }
}
