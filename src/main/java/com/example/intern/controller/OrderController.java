package com.example.intern.controller;

import com.example.intern.dto.RequestDTO.OrderRequest;
import com.example.intern.dto.ResponseDTO.OrderResponse;

import com.example.intern.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    // Injects the OrderService
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        // Call the placeOrder method in the OrderService to process the order
        OrderResponse orderResponse = orderService.placeOrder(orderRequest);
        // Return a response with the created order and HTTP status code 201 (Created)
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
}

