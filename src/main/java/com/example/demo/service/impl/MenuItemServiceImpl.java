package com.example.demo.service.impl;

import com.example.demo.entity.MenuItem;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.MenuItemService;
import java.math.BigDecimal;

public class MenuItemServiceImpl implements MenuItemService {
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, 
                              RecipeIngredientRepository recipeIngredientRepository,
                              CategoryRepository categoryRepository) {}
    
    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        if (menuItem.getSellingPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Invalid price");
        }
        return menuItem;
    }
}