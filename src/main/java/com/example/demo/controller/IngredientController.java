package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import com.example.demo.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController // 🔴 REQUIRED
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PutMapping("/{id}/cost")
    public Ingredient updateCost(@PathVariable Long id,
                                 @RequestParam BigDecimal cost) {
        return ingredientService.updateCost(id, cost);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        ingredientService.deactivate(id);
    }
}
