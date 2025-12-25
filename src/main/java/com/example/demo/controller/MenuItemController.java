package com.example.demo.controller;

import com.example.demo.entity.MenuItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    private final List<MenuItem> items = new ArrayList<>();

    @PostMapping
    public MenuItem createMenuItem(MenuItem item) {
        items.add(item);
        return item;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateMenuItem(long id) {
        items.forEach(i -> i.setActive(false));
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return items;
    }
}
