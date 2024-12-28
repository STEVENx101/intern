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
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
               
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItem(Long id) {
        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"+id));
        return item;
    }

    public void updateItem(Long id, Item item) {

                itemRepository
                    .findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid item id"+id) );

        item.setId(id);
        itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        

        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"+id));
        itemRepository.delete(item);


    }
    
}
