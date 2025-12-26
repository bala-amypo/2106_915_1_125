package com.example.demo.service.impl;

import com.example.demo.entity.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<MenuItem> menuItem = menuItemRepository.findById(id);
        return menuItem.orElseThrow(() -> new RuntimeException("MenuItem not found with id: " + id));
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItemDetails) {
        MenuItem existing = getMenuItemById(id);
        existing.setName(menuItemDetails.getName());
        existing.setPrice(menuItemDetails.getPrice());
        existing.setActive(menuItemDetails.isActive());
        existing.setCategory(menuItemDetails.getCategory());
        return menuItemRepository.save(existing);
    }

    @Override
    public void deleteMenuItem(Long id) {
        MenuItem existing = getMenuItemById(id);
        menuItemRepository.delete(existing);
    }

    @Override
    public void deactivateMenuItem(Long id) {
        MenuItem existing = getMenuItemById(id);
        existing.setActive(false);
        menuItemRepository.save(existing);
    }
}
