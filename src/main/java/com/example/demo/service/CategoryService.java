package com.example.demo.service;

import com.example.demo.entity.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    void deactivateCategory(Long id);
}