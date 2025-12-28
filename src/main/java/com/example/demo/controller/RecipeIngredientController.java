package com.example.demo.controller;

import com.example.demo.entity.RecipeIngredient;
import com.example.demo.service.RecipeIngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe-ingredients")
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @PostMapping
    public ResponseEntity<RecipeIngredient> addIngredient(
            @RequestBody RecipeIngredient recipeIngredient) {
        return new ResponseEntity<>(
                recipeIngredientService.addIngredientToMenuItem(recipeIngredient),
                HttpStatus.CREATED
        );
    }
}
