package com.example.demo.controller;

import com.example.demo.entity.MenuItem;
import com.example.demo.service.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    // Constructor Injection (BEST PRACTICE)
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    // ✅ Create Menu Item
    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem savedItem = menuItemService.createMenuItem(menuItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // ✅ Get Menu Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        return ResponseEntity.ok(menuItem);
    }

    // ✅ Get All Menu Items
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        List<MenuItem> items = menuItemService.getAllMenuItems();
        return ResponseEntity.ok(items);
    }

    // ✅ Update Menu Item
    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(
            @PathVariable Long id,
            @RequestBody MenuItem menuItem) {

        MenuItem updatedItem = menuItemService.updateMenuItem(id, menuItem);
        return ResponseEntity.ok(updatedItem);
    }

    // ✅ Delete Menu Item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.ok("Menu item deleted successfully");
    }
}
