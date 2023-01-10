package org.example.model;

import java.util.List;

public class User {

    int id;
    String name;
    String address;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Order> getPastOrders() {
        return pastOrders;
    }

    private List<Order> pastOrders;

}
