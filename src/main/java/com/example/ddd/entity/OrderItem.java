package com.example.ddd.entity;

public class OrderItem {

    String id;
    String name;
    int price;

    public OrderItem(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
