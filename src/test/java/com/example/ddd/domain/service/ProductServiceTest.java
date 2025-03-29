package com.example.ddd.domain.service;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.ddd.domain.entity.Product;


class ProductServiceTest {
    @Test
    void itShouldChangeThePricesOfAllProducts() {
        var product = new Product("1", "Product1", 100);
        var product2 = new Product("2", "Product2", 200);

        var products = Arrays.asList(product, product2);
        ProductService.increasePrice(products);
        assertEquals(200, product.getPrice());
        assertEquals(400, product2.getPrice());
    }    
}
