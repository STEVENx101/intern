package com.example.intern.controller;

import com.example.intern.entity.Discount;
import com.example.intern.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/discounts")
public class DiscountController {
    @Autowired
    private DiscountService discountService;
   
    // Creates a new discount
    @PostMapping
    public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
        Discount newDiscount = discountService.save(discount); 
        return ResponseEntity.ok(newDiscount);
    }

    // Fetches a discount by code
    @GetMapping("/{code}")
    public ResponseEntity<Discount> getDiscountByCode(@PathVariable String code) {
        Discount discount = discountService.getDiscountByCode(code);
        return ResponseEntity.ok(discount);
    }

    
}