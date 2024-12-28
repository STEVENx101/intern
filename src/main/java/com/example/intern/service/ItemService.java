package com.example.intern.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.intern.entity.Item;
import com.example.intern.repository.ItemRepository;

@Service
public class ItemService {
    // Injects the ItemRepository
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        //Adds a new item to the repository.
        itemRepository.save(item);
               
    }

    public List<Item> getItems() {
        //Retrieves all items from the repository
        return itemRepository.findAll();
    }

    public Item getItem(Long id) {
        //Retrieves a specific item by its ID.Throws an exception if the item is not found
     
        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"+id));
        return item;
    }

    public void updateItem(Long id, Item item) {
        //Updates an existing item by its ID. Throws an exception if the item is not found
                itemRepository
                    .findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid item id"+id) );

        item.setId(id);
        itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        
        //Deletes an existing item by its ID. Throws an exception if the item is not found
        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"+id));
        itemRepository.delete(item);


    }
    
}
