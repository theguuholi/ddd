package com.example.ddd.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private List<OrderItem> orderItem = new ArrayList<OrderItem>();

    public Order(String id, String customerId, List<OrderItem> orderItem) {
        this.id = id;
        this.customerId = customerId;
        this.orderItem = orderItem;
    }

}
