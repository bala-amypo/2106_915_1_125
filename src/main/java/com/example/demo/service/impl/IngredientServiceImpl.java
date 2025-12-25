package com.example.demo.service.impl;

import com.example.demo.service.IngredientService;
import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repo;

    public IngredientServiceImpl(IngredientRepository repo) {
        this.repo = repo;
    }

    public List<Ingredient> getIngredients() {
        return repo.findAll();
    }
}
