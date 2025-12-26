package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.MenuItem;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.RecipeIngredientRepository;
import com.example.demo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, 
                              RecipeIngredientRepository recipeIngredientRepository,
                              CategoryRepository categoryRepository) {
        this.menuItemRepository = menuItemRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        if (menuItem.getSellingPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Invalid price");
        }
        if (menuItemRepository.findByNameIgnoreCase(menuItem.getName()).isPresent()) {
            throw new BadRequestException("MenuItem already exists");
        }
        
        // Validate categories
        for (Category category : menuItem.getCategories()) {
            Category existing = categoryRepository.findById(category.getId())
                    .orElseThrow(() -> new BadRequestException("Category not found"));
            if (!existing.getActive()) {
                throw new BadRequestException("Cannot assign inactive category");
            }
        }
        
        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        MenuItem existing = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found"));
        
        if (menuItem.getActive() && !recipeIngredientRepository.existsByMenuItemId(id)) {
            throw new BadRequestException("Cannot activate menu item without recipe ingredients");
        }
        
        // Validate categories
        for (Category category : menuItem.getCategories()) {
            Category existingCat = categoryRepository.findById(category.getId())
                    .orElseThrow(() -> new BadRequestException("Category not found"));
            if (!existingCat.getActive()) {
                throw new BadRequestException("Cannot assign inactive category");
            }
        }
        
        existing.setCategories(menuItem.getCategories());
        return menuItemRepository.save(existing);
    }

    @Override
    public void deactivateMenuItem(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found"));
        menuItem.setActive(false);
        menuItemRepository.save(menuItem);
    }
}