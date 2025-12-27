package com.example.demo.repository;

import com.example.demo.entity.ProfitCalculationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfitCalculationRecordRepository extends JpaRepository<ProfitCalculationRecord, Long> {
    Optional<ProfitCalculationRecord> findById(Long id);
    List<ProfitCalculationRecord> findByProfitMarginGreaterThanEqual(BigDecimal margin);
    List<ProfitCalculationRecord> findByProfitMarginGreaterThanEqual(double margin);
    List<ProfitCalculationRecord> findByMenuItemId(Long menuItemId);
}