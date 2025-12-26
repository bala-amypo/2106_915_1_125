package com.example.demo.repository;

import com.example.demo.entity.ProfitCalculationRecord;
import java.util.List;
import java.util.Optional;

public interface ProfitCalculationRecordRepository {
    List<ProfitCalculationRecord> findByProfitMarginGreaterThanEqual(Double margin);
    List<ProfitCalculationRecord> findByMenuItemId(Long menuItemId);
    Optional<ProfitCalculationRecord> findById(Long id);
    List<ProfitCalculationRecord> findAll();
    ProfitCalculationRecord save(ProfitCalculationRecord record);
}