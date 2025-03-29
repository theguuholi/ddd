package com.example.ddd.domain.entity;

public class OrderItem {

    String id;
    String name;
    int price;
    String productId;

    public OrderItem(String id, String name, int price, String productId, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price*quantity;
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

}
