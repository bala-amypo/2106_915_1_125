package com.example.demo.service;

import com.example.demo.entity.MenuItem;

public interface MenuItemService {
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem menuItem);
}