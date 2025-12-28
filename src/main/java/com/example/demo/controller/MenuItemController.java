package com.example.demo.controller;

import com.example.demo.service.MenuItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    // 🔥 THIS METHOD IS REQUIRED BY TEST
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateMenuItem(@PathVariable Long id) {
        menuItemService.deactivateMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}
