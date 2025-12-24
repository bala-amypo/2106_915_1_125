package com.example.demo.service.impl;

import com.example.demo.entity.MenuItem;
import com.example.demo.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final List<MenuItem> items = new ArrayList<>();

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        items.add(menuItem);
        return menuItem;
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return items;
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        return menuItem;
    }

    @Override
    public void deleteMenuItem(Long id) {
        MenuItem item = getMenuItemById(id);
        if (item != null) {
            item.deactivate();
        }
    }
}
