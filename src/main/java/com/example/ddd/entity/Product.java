package com.example.ddd.entity;

public class Product {
    private String id;
    private String name;
    private int price;

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validate();
    }

    private void validate() {
        if (this.id.isEmpty()) {
            throw new IllegalArgumentException("ID is required");
        }
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("NAME is required");
        }
        if (this.price <= 0) {
            throw new IllegalArgumentException("PRICE must be higher than 0");
        }
    }

    public String getName() {
        return this.name;
    }

	public void changeName(String aName) {
        this.name = aName;
	}

    public Integer getPrice() {
        return this.price;
    }

    public void changePrice(int newPrice) {
        this.price = newPrice;
    }

}
