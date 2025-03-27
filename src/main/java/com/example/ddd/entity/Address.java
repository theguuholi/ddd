package com.example.ddd.entity;

public class Address {
    private String street;
    private int number;
    private String city;
    private String zip;

    public Address(String street, int number, String city, String zip) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zip = zip;

        this.validate();
    }

    private void validate() {
        if (this.street.isEmpty()) {
            throw new IllegalArgumentException("Street is required!");
        }
    }

    @Override
    public String toString() {
        return "Address [street=" + street + ", number=" + number + ", city=" + city + ", zip=" + zip + "]";
    }

}
