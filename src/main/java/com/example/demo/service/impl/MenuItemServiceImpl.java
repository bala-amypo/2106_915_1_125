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
        if (menuItem.getSellingPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Invalid price");
        }

        menuItemRepository.findByNameIgnoreCase(menuItem.getName())
                .ifPresent(m -> {
                    throw new BadRequestException("Menu item exists");
                });

        validateCategories(menuItem.getCategories());
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));
    }

   @Override
public MenuItem updateMenuItem(Long id, MenuItem menuItem) {

    MenuItem existing = getMenuItemById(id);

    // ===== SAFE duplicate name check =====
    menuItemRepository.findByNameIgnoreCase(menuItem.getName())
            .ifPresent(m -> {
                if (m.getId() != null && !m.getId().equals(id)) {
                    throw new BadRequestException("Duplicate menu item");
                }
            });

    // ===== CRITICAL TEST RULE =====
    if (Boolean.TRUE.equals(menuItem.getActive())
            && !recipeIngredientRepository.existsByMenuItemId(id)) {
        throw new BadRequestException("Cannot activate without recipe");
    }

    validateCategories(menuItem.getCategories());

    existing.setName(menuItem.getName());
    existing.setDescription(menuItem.getDescription());
    existing.setSellingPrice(menuItem.getSellingPrice());
    existing.setActive(menuItem.getActive());
    existing.setCategories(menuItem.getCategories());

    return menuItemRepository.save(existing);
}

    @Override
    public void deactivateMenuItem(Long id) {
        MenuItem item = getMenuItemById(id);
        item.setActive(false);
        menuItemRepository.save(item);
    }

    @Override
    public java.util.List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    private void validateCategories(Set<Category> categories) {
        for (Category c : categories) {
            Category category = categoryRepository.findById(c.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
            if (!category.getActive()) {
                throw new BadRequestException("Inactive category");
            }
        }
    }
}
