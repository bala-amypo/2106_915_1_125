package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profit")
public class ProfitCalculationController {

    @GetMapping("/{cost}")
    public Long calculate(@PathVariable Long cost) {
        return cost * 2;
    }
}
