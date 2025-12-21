package com.example.demo.service.impl;

import com.example.demo.service.ProfitCalculationService;
import org.springframework.stereotype.Service;

@Service
public class ProfitCalculationServiceImpl
        implements ProfitCalculationService {

    @Override
    public Double calculateProfitForMenuItem(Long menuItemId) {
        return 0.0;
    }
}
