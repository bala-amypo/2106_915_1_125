package com.example.demo.service;

import com.example.demo.entity.ProfitCalculationRecord;
import java.util.List;

/**
 * Service interface for calculating and retrieving menu profitability.
 */
public interface ProfitCalculationService {

    /**
     * Calculate profit for a given MenuItem.
     * @param menuItemId the menu item ID
     * @return saved ProfitCalculationRecord
     */
    ProfitCalculationRecord calculateProfit(Long menuItemId);

    /**
     * Get a profit calculation record by ID.
     * @param id record ID
     * @return ProfitCalculationRecord
     */
    ProfitCalculationRecord getCalculationById(Long id);

    /**
     * Get all profit calculation records.
     * @return list of records
     */
    List<ProfitCalculationRecord> getAllCalculations();

    /**
     * Get all profit calculation records for a menu item.
     * @param menuItemId menu item ID
     * @return list of records
     */
    List<ProfitCalculationRecord> getCalculationsForMenuItem(Long menuItemId);
}
