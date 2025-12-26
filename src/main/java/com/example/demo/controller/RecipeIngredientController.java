package com.example.demo.controller;

import com.example.demo.service.RecipeIngredientService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeIngredientController {
    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }
}