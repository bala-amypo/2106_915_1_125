package com.example.demo.controller;

import com.example.demo.service.ProfitCalculationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profit")
public class ProfitController {

    private final ProfitCalculationService profitCalculationService;

    public ProfitController(ProfitCalculationService profitCalculationService) {
        this.profitCalculationService = profitCalculationService;
    }

    @GetMapping("/menu-item/{menuItemId}")
    public Double calculateProfit(@PathVariable Long menuItemId) {
        return profitCalculationService.calculateProfitForMenuItem(menuItemId);
    }
}