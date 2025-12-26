package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import com.example.demo.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    public ResponseEntity<Ingredient> createIngredient(Ingredient ingredient) {
        Ingredient created = ingredientService.createIngredient(ingredient);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    public void deactivateIngredient(Long id) {
        ingredientService.deactivateIngredient(id);
    }
}