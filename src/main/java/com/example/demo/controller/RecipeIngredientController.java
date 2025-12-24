package com.example.demo.controller;

import com.example.demo.entity.RecipeIngredient;
import com.example.demo.service.RecipeIngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-ingredients")
public class RecipeIngredientController {

    private final RecipeIngredientService recipeService;

    public RecipeIngredientController(RecipeIngredientService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public RecipeIngredient add(@RequestBody RecipeIngredient ri) {
        return recipeService.addIngredientToMenuItem(ri);
    }

    @PutMapping("/{id}")
    public RecipeIngredient update(@PathVariable Long id, @RequestParam Double quantity) {
        return recipeService.updateRecipeIngredient(id, quantity);
    }

    @GetMapping("/menu-item/{menuItemId}")
    public List<RecipeIngredient> getByMenuItem(@PathVariable Long menuItemId) {
        return recipeService.getIngredientsByMenuItem(menuItemId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recipeService.removeIngredientFromRecipe(id);
    }

    @GetMapping("/ingredient/{ingredientId}/total-quantity")
    public Double getTotal(@PathVariable Long ingredientId) {
        return recipeService.getTotalQuantityOfIngredient(ingredientId);
    }
}
