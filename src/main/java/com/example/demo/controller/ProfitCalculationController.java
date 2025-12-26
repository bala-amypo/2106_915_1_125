package com.example.demo.controller;

import com.example.demo.service.impl.ProfitCalculationServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfitCalculationController {
    private final ProfitCalculationServiceImpl profitCalculationService;

    public ProfitCalculationController(ProfitCalculationServiceImpl profitCalculationService) {
        this.profitCalculationService = profitCalculationService;
    }
}