package com.example.ddd;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ddd.entity.Address;
import com.example.ddd.entity.Customer;
import com.example.ddd.entity.Order;
import com.example.ddd.entity.OrderItem;

@SpringBootApplication
public class DddApplication {

	public static void main(String[] args) throws Exception {
		var customer = new Customer("123", "Gustavo");
		var address = new Address("street 123", 222, "Americana", "123121");
		customer.setAddress(address);
		customer.activate();

		var item1 = new OrderItem("1", "pumpkin", 10);
		var item2 = new OrderItem("2", "tv", 10);
		var items = Arrays.asList(item1, item2);
		var order = new Order("1", "123", items);
		System.out.println(order);
	}

}
