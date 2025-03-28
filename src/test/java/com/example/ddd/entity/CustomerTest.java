package com.example.ddd.entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    
    @Test
    void givenANewCustomerDoesNotHaveAnIdThenThrowError() {
        assertThrows(IllegalArgumentException.class, () -> new Customer("", "Gustavo"));
    }
}
