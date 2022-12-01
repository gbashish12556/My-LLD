package org.example.model;

import org.example.model.Car;
import org.example.model.Slot;

public class Ticket {

    public Ticket(long id, Car car, Slot slot){
        this.id = id;
        this.car = car;
        this.slot = slot;
    }

    long id;

    public long getId() {
        return id;
    }

    Slot slot;

    public Slot getSlot() {
        return slot;
    }

    public Car getCar() {
        return car;
    }

    Car car;
}
