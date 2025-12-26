package com.example.demo.repository.impl;

import com.example.demo.entity.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MenuItemRepositoryImpl implements MenuItemRepository {
    private final Map<Long, MenuItem> menuItems = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Optional<MenuItem> findByNameIgnoreCase(String name) {
        return menuItems.values().stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        if (menuItem.getId() == null) {
            menuItem.setId(idGenerator.getAndIncrement());
        }
        menuItems.put(menuItem.getId(), menuItem);
        return menuItem;
    }

    @Override
    public Optional<MenuItem> findById(Long id) {
        return Optional.ofNullable(menuItems.get(id));
    }

    @Override
    public List<MenuItem> findAll() {
        return new ArrayList<>(menuItems.values());
    }

    @Override
    public List<MenuItem> findAllActiveWithCategories() {
        return menuItems.values().stream()
                .filter(MenuItem::getActive)
                .toList();
    }
}