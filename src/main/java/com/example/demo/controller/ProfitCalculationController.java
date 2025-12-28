package com.example.demo.controller;

import com.example.demo.entity.ProfitCalculationRecord;
import com.example.demo.service.impl.ProfitCalculationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profits")
public class ProfitCalculationController {

    private final ProfitCalculationServiceImpl profitCalculationService;

    public ProfitCalculationController(ProfitCalculationServiceImpl profitCalculationService) {
        this.profitCalculationService = profitCalculationService;
    }

    @PostMapping("/{menuItemId}")
    public ResponseEntity<ProfitCalculationRecord> calculateProfit(
            @PathVariable Long menuItemId) {
        return ResponseEntity.ok(profitCalculationService.calculateProfit(menuItemId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfitCalculationRecord> getCalculation(@PathVariable Long id) {
        return ResponseEntity.ok(profitCalculationService.getCalculationById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfitCalculationRecord>> getAll() {
        return ResponseEntity.ok(profitCalculationService.getAllCalculations());
    }
}
