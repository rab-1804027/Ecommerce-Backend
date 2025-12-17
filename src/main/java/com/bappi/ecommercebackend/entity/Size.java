package com.bappi.ecommercebackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Size {

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;
}
