package com.example.ddd.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    void givenAProductWhenItDoesNotHaveIDThrowError() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Product("", "Product1", 100));
        assertEquals("ID is required", exception.getMessage());
    }

    @Test
    void givenAProductWhenItDoesNotHaveNameThrowError() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Product("123", "", 100));
        assertEquals("NAME is required", exception.getMessage());
    }

    @Test
    void givenAProductWhenPriceIs0ThrowError() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Product("123", "123", 0));
        assertEquals("PRICE must be higher than 0", exception.getMessage());
    }

    @Test
    void givenAProductWhenTryToChangeNameThenReturnTheActualEntity() {
        var product = new Product("123", "pumpkin", 123);
        product.changeName("Gustavo");
        assertEquals(product.getName(), "Gustavo");
    }

}
