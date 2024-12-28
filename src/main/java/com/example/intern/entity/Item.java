package com.example.intern.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotBlank;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be null or empty")
    private String name;

    @Min(value = 0, message = "Unit price must be greater than 0")
    private Double unitPrice;

    public Item() {

    }

    // Constructor with parameters
    public Item(String name, Double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> lineItems;


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
