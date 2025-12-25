package com.example.demo.controller;

import com.example.demo.service.ProfitCalculationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profit")
public class ProfitCalculationController {

    private final ProfitCalculationService profitService;

    public ProfitCalculationController(ProfitCalculationService profitService) {
        this.profitService = profitService;
    }

    @GetMapping("/{cost}")
    public Long calculate(@PathVariable Long cost) {
        return profitService.calculateProfit(cost);
    }
}
