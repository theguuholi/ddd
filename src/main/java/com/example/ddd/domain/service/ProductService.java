package com.example.ddd.domain.service;

import java.util.List;

import com.example.ddd.domain.entity.Product;

public class ProductService {

    private ProductService() {
    }

    public static void increasePrice(List<Product> products) {
        products.forEach(p -> p.changePrice(p.getPrice() * 2));
    }

}
