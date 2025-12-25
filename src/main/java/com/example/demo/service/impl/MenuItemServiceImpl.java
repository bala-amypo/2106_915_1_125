package com.example.demo.service.impl;

import com.example.demo.service.MenuItemService;
import com.example.demo.entity.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository repo;

    public MenuItemServiceImpl(MenuItemRepository repo) {
        this.repo = repo;
    }

    public List<MenuItem> getMenuItems() {
        return repo.findAll();
    }
}
