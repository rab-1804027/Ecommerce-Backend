package com.bappi.ecommercebackend.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String name;
    private String city;
    private String country;
    private int zipCode;
    private long mobile;

}
