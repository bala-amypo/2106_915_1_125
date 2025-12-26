package com.example.demo.repository.impl;

import com.example.demo.entity.ProfitCalculationRecord;
import com.example.demo.repository.ProfitCalculationRecordRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProfitCalculationRecordRepositoryImpl implements ProfitCalculationRecordRepository {
    private final Map<Long, ProfitCalculationRecord> records = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<ProfitCalculationRecord> findByProfitMarginGreaterThanEqual(Double margin) {
        return records.values().stream()
                .filter(r -> r.getProfitMargin() != null && r.getProfitMargin() >= margin)
                .toList();
    }

    @Override
    public List<ProfitCalculationRecord> findByMenuItemId(Long menuItemId) {
        return records.values().stream()
                .filter(r -> r.getMenuItemId() != null && r.getMenuItemId().equals(menuItemId))
                .toList();
    }

    @Override
    public Optional<ProfitCalculationRecord> findById(Long id) {
        return Optional.ofNullable(records.get(id));
    }

    @Override
    public List<ProfitCalculationRecord> findAll() {
        return new ArrayList<>(records.values());
    }

    @Override
    public ProfitCalculationRecord save(ProfitCalculationRecord record) {
        if (record.getId() == null) {
            record.setId(idGenerator.getAndIncrement());
        }
        records.put(record.getId(), record);
        return record;
    }
}