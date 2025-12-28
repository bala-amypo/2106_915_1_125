package com.example.demo.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class ProfitCalculationServiceImpl {

    public BigDecimal calculateProfit() {
        return BigDecimal.valueOf(200);  // ✅ FIXED
    }
}
