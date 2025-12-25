package com.example.demo.service;

import java.util.List;

public interface ProfitCalculationService {
    String getCalculationById(Long id);
    List<String> getCalculationsForMenuItem(Long menuItemId);
    List<String> getAllCalculations();
}