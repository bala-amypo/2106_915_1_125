package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.MenuItem;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.math.BigDecimal;

public class CategoryServiceImpl implements CategoryService {
    public CategoryServiceImpl(CategoryRepository categoryRepository) {}
}

class MenuItemServiceImpl implements MenuItemService {
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

class RecipeIngredientServiceImpl implements RecipeIngredientService {
    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngredientRepository,
                                     IngredientRepository ingredientRepository,
                                     MenuItemRepository menuItemRepository) {}
}

class ProfitCalculationServiceImpl {
    public ProfitCalculationServiceImpl(MenuItemRepository menuItemRepository,
                                      RecipeIngredientRepository recipeIngredientRepository,
                                      IngredientRepository ingredientRepository,
                                      ProfitCalculationRecordRepository profitCalculationRecordRepository) {}
}

class UserServiceImpl implements UserService {
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {}
}