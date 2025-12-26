package com.example.demo.service.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        Optional<Ingredient> optional = ingredientRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Ingredient not found with id: " + id));
    }

    @Override
    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        Ingredient existing = getIngredientById(id);
        existing.setName(ingredient.getName());
        existing.setQuantity(ingredient.getQuantity());
        existing.setUnit(ingredient.getUnit());
        existing.setActive(ingredient.isActive());
        return ingredientRepository.save(existing);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
