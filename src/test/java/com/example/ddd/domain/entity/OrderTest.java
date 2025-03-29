package com.example.ddd.domain.entity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


class OrderTest {

    @Test
    void givenAnOrderWhenIdIsEmptyThenThrowError() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Order("", "Gustavo", null));
        assertEquals("ID is required", exception.getMessage());
    }

    @Test
    void givenAnOrderWhenItDoesNotHaveItemThrowError() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Order("123", "Gustavo", Arrays.asList()));
        assertEquals("Items are required", exception.getMessage());
    }

    @Test
    void givenAnOrderThenCalculateTotal() {
        var item = new OrderItem("1", "1", 1, "123", 2);
        var item2 = new OrderItem("2", "2", 2, "123", 1);
        var order = new Order("123", "Gustavo", Arrays.asList(item, item2));
        assertEquals(4, order.total());
    }

}
