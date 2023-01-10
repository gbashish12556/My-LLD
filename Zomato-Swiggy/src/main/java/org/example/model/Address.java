package org.example.model;

import org.example.enums.CityName;

public class Address {

    String address;

    public String getAddress() {
        return address;
    }

    public CityName getCityName() {
        return cityName;
    }

    CityName cityName;
}
