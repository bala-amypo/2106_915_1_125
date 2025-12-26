package com.example.demo.controller;

import com.example.demo.service.RecipeIngredientService;

public class RecipeIngredientController {
    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }
}