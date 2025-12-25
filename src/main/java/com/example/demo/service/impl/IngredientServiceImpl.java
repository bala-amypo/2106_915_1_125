package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final List<Ingredient> ingredients = new ArrayList<>();

    @PostMapping
    public Ingredient createIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        return ingredient;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateIngredient(long id) {
        ingredients.forEach(i -> i.setActive(false));
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredients;
    }
}
