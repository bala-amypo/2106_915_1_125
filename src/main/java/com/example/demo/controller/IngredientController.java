package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import com.example.demo.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(
            @RequestBody Ingredient ingredient) {
        return new ResponseEntity<>(ingredient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivateIngredient(@PathVariable Long id) {
        return ResponseEntity.ok("Ingredient deactivated");
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(List.of());
    }
}
