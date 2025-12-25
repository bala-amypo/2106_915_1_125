package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @GetMapping
    public List<String> getIngredients() {
        return List.of("Sugar", "Salt", "Flour");
    }
}
