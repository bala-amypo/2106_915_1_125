package com.example.demo.service;

import com.example.demo.entity.ProfitCalculationRecord;
import java.math.BigDecimal;
import java.util.List;

public interface ProfitCalculationService {
    BigDecimal calculateProfit(Long menuItemId);
    ProfitCalculationRecord getCalculationById(Long id);
    List<ProfitCalculationRecord> findRecordsWithMarginBetween(double min, double max);
    List<ProfitCalculationRecord> getCalculationsForMenuItem(Long menuItemId);
    List<ProfitCalculationRecord> getAllCalculations();
}