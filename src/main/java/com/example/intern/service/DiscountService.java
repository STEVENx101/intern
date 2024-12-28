package com.example.intern.service;

import com.example.intern.entity.Discount;
import com.example.intern.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    // Injects the DiscountRepository
    @Autowired
    private DiscountRepository discountRepository;

//Retrieves a discount by its code. If the discount is not found, a RuntimeException is thrown
    public Discount getDiscountByCode(String code) {
        return discountRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException(" Discount not found with code: " + code));
    }


   
    public Discount save(Discount discount) {
        //Saves a new or updated discount to the database
        return discountRepository.save(discount);
    }
}
