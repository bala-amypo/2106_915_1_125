package com.example.demo.controller;

import com.example.demo.entity.MenuItem;
import com.example.demo.service.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class MenuItemController {
    private final MenuItemService menuItemService;
    
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }
    
    public ResponseEntity<MenuItem> createMenuItem(MenuItem menuItem) {
        MenuItem created = menuItemService.createMenuItem(menuItem);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    public void deactivateMenuItem(Long id) {}
    
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(List.of(new MenuItem()));
    }
}