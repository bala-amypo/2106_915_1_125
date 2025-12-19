package com.example.demo.controller;

import com.example.demo.entity.RecipeIngredient;
import com.example.demo.service.RecipeIngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe-ingredients")
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @PostMapping
    public RecipeIngredient addIngredient(@RequestBody RecipeIngredient recipeIngredient) {
        return recipeIngredientService.addIngredientToMenuItem(recipeIngredient);
    }

    @PutMapping("/{id}")
    public RecipeIngredient updateIngredient(@PathVariable Long id,
                                              @RequestParam Double quantity) {
        return recipeIngredientService.updateRecipeIngredient(id, quantity);
    }

    @GetMapping("/menu-item/{menuItemId}")
    public List<RecipeIngredient> getByMenuItem(@PathVariable Long menuItemId) {
        return recipeIngredientService.getIngredientsByMenuItem(menuItemId);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        recipeIngredientService.removeIngredientFromRecipe(id);
    }
}