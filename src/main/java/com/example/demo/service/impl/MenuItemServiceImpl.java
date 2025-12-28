package com.example.demo.service.impl;

import com.example.demo.service.MenuItemService;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Override
    public void deactivateMenuItem(Long id) {
        // business logic (dummy for now)
        System.out.println("Menu item " + id + " deactivated");
    }
}
