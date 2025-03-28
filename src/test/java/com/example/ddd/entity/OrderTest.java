package com.example.ddd.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void givenAnOrderWhenIdIsEmptyThenThrowError() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Order("", "Gustavo", null));
        assertEquals("ID is required", exception.getMessage());
    }
}
