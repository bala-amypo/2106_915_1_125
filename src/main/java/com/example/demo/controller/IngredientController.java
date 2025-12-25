package com.example.demo.controller;

import com.example.demo.service.IngredientService;
import com.example.demo.entity.Ingredient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ingredient> getAll() {
        return service.getIngredients();
    }
}
