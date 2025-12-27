package com.example.demo.service;

import com.example.demo.entity.Category;

public interface CategoryService {
    Category createCategory(Category category);
    void deactivateCategory(Long id);
    Category getCategoryById(Long id);
}