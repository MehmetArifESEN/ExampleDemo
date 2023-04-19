package com.bilgeadam.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String country;
    private String street;

    public Address() {
    }

    public Address(String city, String country, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }
}
