package com.example.ddd.domain.service;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.ddd.domain.entity.Customer;
import com.example.ddd.domain.entity.Order;
import com.example.ddd.domain.entity.OrderItem;

class OrderServiceTest {

    @Test
    void itShouldCalculateTotal() {
        var item1 = new OrderItem("1", "item1", 100, "p1", 1);
        var item2 = new OrderItem("2", "item2", 200, "p1", 2);

        var order = new Order("1", "c1", Arrays.asList(item1));
        var order2 = new Order("2", "c1", Arrays.asList(item2));

        var orders = Arrays.asList(order, order2);
        var total = OrderService.total(orders);
        assertEquals(500, total);
    }

    @Test
    void itShouldPlaceAnOrder() {
        var customer = new Customer("123d", "Gustavo");
        var item = new OrderItem("o1", "item 1", 10, "p1", 1);

        var order = OrderService.placeOrder(customer, Arrays.asList(item));
        assertEquals(5, customer.getRewardPoints());
        assertEquals(10, order.total());
    }

    @Test
    void itShouldThrowErrorPlaceAnOrder() {
        var customer = new Customer("123d", "Gustavo");
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> OrderService.placeOrder(customer, Arrays.asList()));
        assertEquals("Order must have at least one item", exception.getMessage());

    }
}
