package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class calculator_controller {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
        int sum = a + b;
        return ResponseEntity.ok(sum);
    }

    @GetMapping("/subtract")
    public ResponseEntity<Integer> subtract(@RequestParam int a, @RequestParam int b) {
        int sub = a - b;
        return ResponseEntity.ok(sub);
    }

    @GetMapping("/multiply")
    public ResponseEntity<Integer> multiply(@RequestParam int a, @RequestParam int b) {
        int multi = a * b;
        return ResponseEntity.ok(multi);
    }

    @GetMapping("/divide")
    public ResponseEntity<Integer> divide(@RequestParam int a, @RequestParam int b) {
        try {
            int result = calculatorService.divide(a, b);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }
}
