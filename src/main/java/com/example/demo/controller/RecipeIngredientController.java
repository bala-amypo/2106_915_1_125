package com.example.demo.controller;

import com.example.demo.service.RecipeIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe-ingredients")
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @GetMapping
    public ResponseEntity<String> getAllRecipeIngredients() {
        return ResponseEntity.ok("Recipe ingredients fetched");
    }
}
