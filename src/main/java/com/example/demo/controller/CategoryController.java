package com.example.demo.controller;

import com.example.demo.service.CategoryService;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}