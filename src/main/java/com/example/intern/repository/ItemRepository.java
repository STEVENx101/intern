package com.example.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
