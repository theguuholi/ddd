package com.example.ddd.services;

import java.util.List;

import com.example.ddd.entity.Product;

public class ProductService {

    public static void increasePrice(List<Product> products) {
        products.forEach(p -> p.changePrice(p.getPrice() * 2));
    }

}
