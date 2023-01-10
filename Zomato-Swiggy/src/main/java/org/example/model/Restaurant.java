package org.example.model;

import javax.swing.*;

public class Restaurant {

    private Integer id;
    private String name;
    private Address address;
    private FoodMenu foodMenu;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public FoodMenu getFoodMenu() {
        return foodMenu;
    }
}
