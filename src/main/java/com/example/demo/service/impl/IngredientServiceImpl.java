package com.example.demo.service.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    
    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        if (ingredientRepository.findByNameIgnoreCase(ingredient.getName()).isPresent()) {
            throw new BadRequestException("Ingredient already exists");
        }
        return ingredientRepository.save(ingredient);
    }
    
    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));
    }
    
    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
    
    @Override
    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        if (!ingredientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ingredient not found");
        }
        ingredient.setId(id);
        return ingredientRepository.save(ingredient);
    }
    
    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}