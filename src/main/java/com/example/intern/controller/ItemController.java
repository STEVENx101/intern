package com.example.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.intern.service.ItemService;
import com.example.intern.model.Item;
import java.util.List; 

@RestController
@RequestMapping("/api/items")
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    @PostMapping("/add")
    public String addItem(@RequestBody Item item) {
        itemService.addItem(item);
        
        return "Item added successfully";
    }

    @GetMapping()
    public List<Item> getItems() { 
        return itemService.getItems();
    }

    @GetMapping("/get/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItem(id); 


    }

}



