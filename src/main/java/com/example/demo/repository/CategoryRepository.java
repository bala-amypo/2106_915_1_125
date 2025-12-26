package com.example.demo.repository;

import com.example.demo.entity.Category;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findByNameIgnoreCase(String name);
    Category save(Category category);
    Optional<Category> findById(Long id);
}