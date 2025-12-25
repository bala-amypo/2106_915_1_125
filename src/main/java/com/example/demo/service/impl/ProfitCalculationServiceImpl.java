package com.example.demo.service.impl;

import com.example.demo.service.ProfitCalculationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfitCalculationServiceImpl implements ProfitCalculationService {

    @Override
    public String getCalculationById(Long id) {
        return "Profit Data";
    }

    @Override
    public List<String> getCalculationsForMenuItem(Long menuItemId) {
        return List.of("Profit1", "Profit2");
    }

    @Override
    public List<String> getAllCalculations() {
        return List.of("Profit1", "Profit2", "Profit3");
    }
}
