package com.example.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern.entity.Discount;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Optional<Discount> findByCode(String code);
}
