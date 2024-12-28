package com.example.intern.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.dto.RequestDTO.OrderRequest;
import com.example.intern.dto.ResponseDTO.OrderResponse;

import com.example.intern.entity.OrderDetails;
import com.example.intern.repository.DiscountRepository;
import com.example.intern.repository.ItemRepository;
import com.example.intern.repository.OrderRepository;
import com.example.intern.entity.LineItem;
import com.example.intern.entity.Discount;
import com.example.intern.entity.Item;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private DiscountRepository discountRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
    // Create the order details
    OrderDetails orderDetails = new OrderDetails();
    orderDetails.setCustomerName(orderRequest.getCustomerName());
    orderDetails.setDiscountCode(orderRequest.getDiscountCode());

    // Calculate total amount from line items
    List<LineItem> lineItems = orderRequest.getLineItems().stream().map(lineItemRequest -> {
        Item item = itemRepository.findById(lineItemRequest.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));
        LineItem lineItem = new LineItem();
        lineItem.setItem(item);
        lineItem.setQuantity(lineItemRequest.getQuantity());
        lineItem.setLineTotal(item.getUnitPrice() * lineItemRequest.getQuantity());
        lineItem.setOrderDetails(orderDetails);
        return lineItem;
    }).toList();

    double totalAmount = lineItems.stream().mapToDouble(LineItem::getLineTotal).sum();

    // Apply discount (if applicable)
    if (orderRequest.getDiscountCode() != null) {
        Discount discount = discountRepository.findByCode(orderRequest.getDiscountCode())
                .orElseThrow(() -> new RuntimeException("Invalid discount code"));
        if (discount.getValidUntil().before(new Date())) {
            throw new RuntimeException("Discount code has expired");
        }

        // Apply discount
        double discountAmount = totalAmount * (discount.getPercentage() / 100.0);
        totalAmount -= discountAmount;
    }

    // Set total amount and save order details
    orderDetails.setTotalAmount(totalAmount);
    orderDetails.setLineItems(lineItems);
    OrderDetails savedOrder = orderRepository.save(orderDetails);

    // Convert saved order to response DTO
    OrderResponse orderResponse = new OrderResponse();
    orderResponse.setOrderId(savedOrder.getOrderId());
    orderResponse.setCustomerName(savedOrder.getCustomerName());
    orderResponse.setTotalAmount(savedOrder.getTotalAmount());
    orderResponse.setDiscountCode(savedOrder.getDiscountCode());
    orderResponse.setLineItems(savedOrder.getLineItems().stream().map(lineItem -> {
        OrderResponse.LineItemResponse response = new OrderResponse.LineItemResponse();
        response.setItemId(lineItem.getItem().getId());
        response.setItemName(lineItem.getItem().getName());
        response.setQuantity(lineItem.getQuantity());
        response.setLineTotal(lineItem.getLineTotal());
        return response;
    }).toList());

    return orderResponse;
}

}
