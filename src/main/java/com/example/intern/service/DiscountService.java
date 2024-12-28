package com.example.intern.service;

import com.example.intern.entity.Discount;
import com.example.intern.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public Discount getDiscountByCode(String code) {
        return discountRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException(" Discount not found with code: " + code));
    }


   
    public Discount save(Discount discount) {
        
        return discountRepository.save(discount);
    }
}
