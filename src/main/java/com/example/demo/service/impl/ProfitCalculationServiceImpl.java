package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProfitCalculationServiceImpl {

    // ✅ ONLY BigDecimal math
    public BigDecimal calculateProfit(BigDecimal sellingPrice,
                                      BigDecimal costPrice) {

        return sellingPrice.subtract(costPrice);
    }
}
