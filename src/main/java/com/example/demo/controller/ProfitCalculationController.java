package com.example.demo.controller;

import com.example.demo.service.impl.ProfitCalculationServiceImpl;

public class ProfitCalculationController {
    private final ProfitCalculationServiceImpl profitCalculationService;
    
    public ProfitCalculationController(ProfitCalculationServiceImpl profitCalculationService) {
        this.profitCalculationService = profitCalculationService;
    }
}