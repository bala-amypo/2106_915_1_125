package com.example.demo.repository;

import com.example.demo.entity.MenuItem;
import java.util.List;
import java.util.Optional;

public interface MenuItemRepository {
    Optional<MenuItem> findByNameIgnoreCase(String name);
    MenuItem save(MenuItem menuItem);
    Optional<MenuItem> findById(Long id);
    List<MenuItem> findAll();
    List<MenuItem> findAllActiveWithCategories();
}