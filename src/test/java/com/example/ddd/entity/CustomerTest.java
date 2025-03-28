package com.example.ddd.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void givenANewCustomerDoesNotHaveAnIdThenThrowError() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Customer("", "Gustavo"));
        assertEquals("ID is required", exception.getMessage());
    }

    @Test
    void givenACustomerWhenDoesNotHaveNameThenThrowNameIsRequired() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Customer("123", ""));
        assertEquals("Name is required", exception.getMessage());
    }
}
