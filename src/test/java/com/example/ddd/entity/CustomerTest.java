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

    @Test
    void givenACustomerWhenChangeNameThenUpdateEntityWithNewName() {
        var customer = new Customer("123", "Gus");
        customer.changeName("Gustavo");
        assertEquals("Gustavo", customer.name);
    }

    @Test
    void givenACustomerWhenTriesToActiveWithouAddressThenThrowAnError() {
        var customer = new Customer("123", "Gus");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> customer.activate());

        assertEquals("Address is mandatory to active the user", exception.getMessage());
    }

    @Test
    void givenACustomerWhenActiveWithoutAddressThenThrowError() {
        var customer = new Customer("123", "Gus");
        var address = new Address("test", 123, "gus", "123123");
        customer.setAddress(address);
        customer.activate();
        assertEquals(true, customer.isActive());
    }

    @Test
    void givenACustomerWhenDeactiveThenReturnFalse() {
        var customer = new Customer("123", "Gus");
        var address = new Address("test", 123, "gus", "123123");
        customer.setAddress(address);
        customer.activate();
        customer.deactivate();
        assertEquals(false, customer.isActive());
    }

    @Test
    void shouldAddRewardPoints() {
        var customer = new Customer("123", "Gus");
        assertEquals(0, customer.getRewardPoints());

        customer.addRewardPoints(10);
        assertEquals(10, customer.getRewardPoints());

        customer.addRewardPoints(20);
        assertEquals(30, customer.getRewardPoints());
    }
}
