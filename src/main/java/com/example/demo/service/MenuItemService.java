package com.example.demo.service;

import com.example.demo.entity.MenuItem;
import java.util.List;

public interface MenuItemService {

    // Create or save a menu item
    MenuItem saveMenuItem(MenuItem menuItem);

    // Retrieve all menu items
    List<MenuItem> getAllMenuItems();

    // Retrieve a menu item by its ID
    MenuItem getMenuItemById(Long id);

    // Update a menu item by ID
    MenuItem updateMenuItem(Long id, MenuItem menuItem);

    // Delete a menu item by ID
    void deleteMenuItem(Long id);

    // Deactivate a menu item (set active=false)
    void deactivateMenuItem(Long id);
}
