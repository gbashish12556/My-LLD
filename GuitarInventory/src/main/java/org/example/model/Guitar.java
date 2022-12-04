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
                  GuitarSpec guitarSpec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.guitarSpec  = guitarSpec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }


    public double getPrice() {
        return price;
    }




}