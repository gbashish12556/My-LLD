package org.example.model;

import org.example.enums.Builder;
import org.example.enums.Type;
import org.example.enums.Wood;

public class Guitar {

    private String serialNumber;
    private double price;

    public GuitarSpec getGuitarSpec() {
        return guitarSpec;
    }

    private GuitarSpec guitarSpec;

    public Guitar(String serialNumber, double price,
                  Builder builder, String model, Type type,
                  Wood backWood, Wood topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.guitarSpec = new GuitarSpec(builder, model, type, topWood, backWood);
    }

    public String getSerialNumber() {
        return serialNumber;
    }


    public double getPrice() {
        return price;
    }



}