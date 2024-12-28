package com.example.intern.dto.ResponseDTO;

import java.util.List;

public class OrderResponse {

    private Long orderId;
    private String customerName;
    private Double totalAmount;
    private String discountCode;
    private List<LineItemResponse> lineItems;

    public static class LineItemResponse {
        private Long itemId;
        private String itemName; 
        private Integer quantity;
        private Double lineTotal;

        // Getters and Setters
        public Long getItemId() {
            return itemId;
        }

        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getLineTotal() {
            return lineTotal;
        }

        public void setLineTotal(Double lineTotal) {
            this.lineTotal = lineTotal;
        }
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public List<LineItemResponse> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemResponse> lineItems) {
        this.lineItems = lineItems;
    }
}
