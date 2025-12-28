package com.example.demo.controller;

import com.example.demo.service.impl.ProfitCalculationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/profit")
public class ProfitCalculationController {

    private final ProfitCalculationServiceImpl profitService;

    public ProfitCalculationController(ProfitCalculationServiceImpl profitService) {
        this.profitService = profitService;
    }

    @GetMapping
    public ResponseEntity<BigDecimal> calculateProfit() {
        return ResponseEntity.ok(profitService.calculateProfit());
    }
}
