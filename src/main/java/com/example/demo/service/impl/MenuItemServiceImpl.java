package com.example.demo.service.impl;

import com.example.demo.entity.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        MenuItem existing = menuItemRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(menuItem.getName());
            existing.setPrice(menuItem.getPrice());
            existing.setActive(menuItem.isActive());
            existing.setCategory(menuItem.getCategory());
            return menuItemRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public void deactivateMenuItem(Long id) {
        MenuItem existing = menuItemRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setActive(false);
            menuItemRepository.save(existing);
        }
    }
}
