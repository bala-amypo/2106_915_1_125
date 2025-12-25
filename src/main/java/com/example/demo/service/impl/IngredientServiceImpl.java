package com.example.demo.service.impl;

import com.example.demo.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Override
    public List<String> getIngredients() {
        return List.of("Salt", "Sugar", "Oil");
    }
}
