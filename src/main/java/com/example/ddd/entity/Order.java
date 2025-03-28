package com.example.ddd.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private List<OrderItem> orderItem = new ArrayList<OrderItem>();

    public Order(String id, String customerId, List<OrderItem> orderItem) {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("ID is required");
        }

        if(orderItem.isEmpty()) {
            throw new IllegalArgumentException("Items are required");
        }
        this.id = id;
        this.customerId = customerId;
        this.orderItem = orderItem;
    }

    public int total() {
        return orderItem.stream().map(OrderItem::getPrice).reduce(0, Integer::sum);
    }

}
