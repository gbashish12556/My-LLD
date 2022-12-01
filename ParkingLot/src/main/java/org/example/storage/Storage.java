package org.example.storage;

import org.example.exception.NoCarFoundException;
import org.example.exception.NoSlotFoundExecption;
import org.example.exception.ParkingLotIsFullException;
import org.example.model.Car;
import org.example.model.Slot;
import org.example.model.Ticket;

import java.util.List;

public interface Storage {

    abstract List<Car> getCarsWithColors(String color) throws NoCarFoundException;
    abstract Slot getSlot(String regNo) throws NoSlotFoundExecption;
    abstract List<Slot> getSlots(String color) throws NoSlotFoundExecption;
    abstract Ticket addCar(Car car) throws ParkingLotIsFullException;
    abstract void removeCar(Slot slot) throws NoCarFoundException;

    abstract void removeCar(int slotNo) throws NoCarFoundException;

    abstract int getSize();

}
