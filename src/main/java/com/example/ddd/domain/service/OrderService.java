/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.ddd.domain.service;

import java.util.List;
import java.util.UUID;

import com.example.ddd.domain.entity.Customer;
import com.example.ddd.domain.entity.Order;
import com.example.ddd.domain.entity.OrderItem;

class OrderService {

    public static int total(List<Order> orders) {
        return orders.stream().map(Order::total).reduce(0, Integer::sum);
    }

    public static Order placeOrder(Customer customer, List<OrderItem> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
        var id = UUID.randomUUID().toString();
        var order = new Order(id, customer.getId(), items);
        customer.addRewardPoints(order.total() / 2);
        return order;
    }

}
