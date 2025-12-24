package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.MenuItem;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.RecipeIngredientRepository;
import com.example.demo.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final CategoryRepository categoryRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository,
                               RecipeIngredientRepository recipeIngredientRepository,
                               CategoryRepository categoryRepository) {
        this.menuItemRepository = menuItemRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {

        // price validation
        if (menuItem.getSellingPrice() == null ||
                menuItem.getSellingPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Invalid selling price");
        }

        // unique name
        menuItemRepository.findByNameIgnoreCase(menuItem.getName())
                .ifPresent(m -> {
                    throw new BadRequestException("Menu item already exists");
                });

        // validate categories
        if (menuItem.getCategories() != null && !menuItem.getCategories().isEmpty()) {
            Set<Category> validatedCategories = new HashSet<>();

            for (Category c : menuItem.getCategories()) {
                Category category = categoryRepository.findById(c.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

                if (!category.isActive()) {
                    throw new BadRequestException("Inactive category cannot be assigned");
                }

                validatedCategories.add(category);
            }
            menuItem.setCategories(validatedCategories);
        }

        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {

        MenuItem existing = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));

        // activating without recipe ingredients not allowed
        if (menuItem.isActive() &&
                !recipeIngredientRepository.existsByMenuItemId(id)) {
            throw new BadRequestException(
                    "Menu item cannot be active without recipe ingredients");
        }

        // validate categories
        if (menuItem.getCategories() != null && !menuItem.getCategories().isEmpty()) {
            Set<Category> validatedCategories = new HashSet<>();

            for (Category c : menuItem.getCategories()) {
                Category category = categoryRepository.findById(c.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

                if (!category.isActive()) {
                    throw new BadRequestException("Inactive category cannot be assigned");
                }

                validatedCategories.add(category);
            }
            existing.setCategories(validatedCategories);
        }

        existing.setName(menuItem.getName());
        existing.setDescription(menuItem.getDescription());
        existing.setSellingPrice(menuItem.getSellingPrice());
        existing.setActive(menuItem.isActive());

        return menuItemRepository.save(existing);
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public void deactivateMenuItem(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));

        menuItem.setActive(false);
        menuItemRepository.save(menuItem);
    }
}
