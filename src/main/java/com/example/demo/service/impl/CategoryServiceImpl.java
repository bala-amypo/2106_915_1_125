package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final List<Category> categories = new ArrayList<>();

    @Override
    public Category createCategory(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categories.stream().findFirst().orElse(null);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return category;
    }

    @Override
    public void deactivateCategory(Long id) {
        // dummy implementation for tests
    }
}
