package com.example.demo.controller;

import com.example.demo.entity.ProfitCalculationRecord;
import com.example.demo.service.ProfitCalculationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profit")
public class ProfitCalculationController {

    private final ProfitCalculationService profitService;

    public ProfitCalculationController(ProfitCalculationService profitService) {
        this.profitService = profitService;
    }

    @PostMapping("/calculate/{menuItemId}")
    public ProfitCalculationRecord calculate(@PathVariable Long menuItemId) {
        return profitService.calculateProfit(menuItemId);
    }

    @GetMapping("/{id}")
    public ProfitCalculationRecord getById(@PathVariable Long id) {
        return profitService.getCalculationById(id);
    }

    @GetMapping("/menu-item/{menuItemId}")
    public List<ProfitCalculationRecord> getByMenuItem(@PathVariable Long menuItemId) {
        return profitService.getCalculationsForMenuItem(menuItemId);
    }

    @GetMapping
    public List<ProfitCalculationRecord> getAll() {
        return profitService.getAllCalculations();
    }
}
