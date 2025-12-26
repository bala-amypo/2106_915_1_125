package com.example.demo.service;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
    void deactivateCategory(Long id);  // <-- This must be implemented
}
