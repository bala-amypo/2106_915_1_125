package com.example.demo.service.impl;

import com.example.demo.service.ProfitCalculationService;
import com.example.demo.entity.MenuItem;
import org.springframework.stereotype.Service;

@Service
public class ProfitCalculationServiceImpl implements ProfitCalculationService {

    public double calculateProfit(MenuItem item) {
        return item.getSellingPrice();
    }
}
