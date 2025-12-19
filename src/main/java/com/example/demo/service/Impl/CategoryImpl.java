
package com.example.demo.service.impl;

import com.example.demo.entity.Ingredient;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.service.IngredientService;

import java.math.BigDecimal;
import java.util.List;

public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    // ⚠️ Constructor order matters (tests use this)
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {

        ingredientRepository.findByNameIgnoreCase(ingredient.getName())
                .ifPresent(i -> {
                    throw new BadRequestException("Ingredient name already exists");
                });

        if (ingredient.getCostPerUnit() == null
                || ingredient.getCostPerUnit().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Cost per unit must be greater than zero");
        }

        ingredient.setActive(true);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateIngredient(Long id, Ingredient updated) {

        Ingredient existing = ingredientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));

        existing.setName(updated.getName());
        existing.setUnit(updated.getUnit());
        existing.setCostPerUnit(updated.getCostPerUnit());

        return ingredientRepository.save(existing);
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
    public void deactivateIngredient(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));

        ingredient.setActive(false);
        ingredientRepository.save(ingredient);
    }
}
Cat
package com.example.demo.service;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category updateCategory(Long id, Category category);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

    void deactivateCategory(Long id);
}
Impl
package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {

        categoryRepository.findByNameIgnoreCase(category.getName())
                .ifPresent(c -> {
                    throw new BadRequestException("Category name already exists");
                });

        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category updated) {

        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());

        return categoryRepository.save(existing);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deactivateCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setActive(false);
        categoryRepository.save(category);
    }
}
