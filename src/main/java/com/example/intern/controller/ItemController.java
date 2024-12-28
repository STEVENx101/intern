package com.example.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intern.entity.Item;
import com.example.intern.service.ItemService;

import java.util.List; 

@RestController
@RequestMapping("/api/items")
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    // Add a new item
    @PostMapping("/add")
    public String addItem(@RequestBody Item item) {
        itemService.addItem(item);
        
        return "Item added successfully";
    }

    // Retrieve all items
    @GetMapping()
    public List<Item> getItems() { 
        return itemService.getItems();
    }

    // Retrieve an item by its ID
    @GetMapping("/get/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItem(id); 
    }

    // Update an item by its ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateItem(@PathVariable Long id, @RequestBody Item item) {
        itemService.updateItem(id, item);
        return ResponseEntity.noContent().build();
    }

    // Delete an item by its ID
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}




