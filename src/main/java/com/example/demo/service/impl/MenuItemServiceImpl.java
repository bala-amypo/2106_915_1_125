package com.example.demo.service.impl;

import com.example.demo.entity.MenuItem;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.MenuItemService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

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
        return menuItemRepository.save(menuItem);
    }
    
    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        MenuItem existing = menuItemRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(menuItem.getName());
            existing.setDescription(menuItem.getDescription());
            existing.setSellingPrice(menuItem.getSellingPrice());
            existing.setActive(menuItem.getActive());
            if (menuItem.getCategories() != null) {
                existing.setCategories(menuItem.getCategories());
            }
            return menuItemRepository.save(existing);
        }
        return null;
    }
}