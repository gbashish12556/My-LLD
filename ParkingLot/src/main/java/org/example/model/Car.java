package org.example.model;

public class Car {

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getColor() {
        return color;
    }

    String registrationNo;
    String color;

    public Car(String registrationNo, String color){
        this.color = color;
        this.registrationNo = registrationNo;
    }

}
