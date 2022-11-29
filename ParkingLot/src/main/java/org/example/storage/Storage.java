package org.example.storage;

import org.example.exception.NoCarFoundException;
import org.example.exception.NoSlotFoundExecption;
import org.example.model.Car;
import org.example.model.Slot;

import java.util.List;

public interface Storage {

    abstract List<Car> getCarsWithColors(String color) throws NoCarFoundException;
    abstract Slot getSlot(String regNo) throws NoSlotFoundExecption;
    abstract List<Slot> getSlots(String color) throws NoSlotFoundExecption;
    abstract void addCar(Car car);
    abstract void removeCar(Slot slot) throws NoCarFoundException;

    abstract int getSize();

}
