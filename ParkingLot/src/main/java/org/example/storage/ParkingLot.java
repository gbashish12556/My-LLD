package org.example.storage;

import org.example.exception.NoCarFoundException;
import org.example.exception.NoSlotFoundExecption;
import org.example.exception.ParkingLotIsFullException;
import org.example.model.Car;
import org.example.model.Slot;
import org.example.strategy.SlotPickingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements Storage{

     private int size;
     private ArrayList<Slot> slots = new ArrayList<>();
     private SlotPickingStrategy slotPickingStrategy;

     ParkingLot(int size, SlotPickingStrategy slotPickingStrategy){

         this.size = size;
         this.slotPickingStrategy = slotPickingStrategy;

         intialiseParkingLot();
     }

     private void intialiseParkingLot(){
         for(int i=1; i<=size; i++){
             slots.add(new Slot(i));
         }
     }


    @Override
    public List<Car> getCarsWithColors(String color) throws NoCarFoundException {
        List<Car> carsList = new ArrayList<>();
        for(int i=1; i<=size; i++){
            Slot slot = slots.get(i);
            if(!slot.isEmpty()){
                Car car = slot.getParkedCar();
                if(car.getColor() == color){
                    carsList.add(car);
                }
            }
        }

        if(carsList.size() > 0){
            return carsList;
        }

        throw new NoCarFoundException();
    }

    @Override
    public Slot getSlot(String regNo) throws NoSlotFoundExecption {

        for(int i=1; i<=size; i++){
            Slot slot = slots.get(i);
            if(!slot.isEmpty()){
                Car car = slot.getParkedCar();
                if(car.getRegistrationNo() == regNo){
                   return slot;
                }
            }
        }

        throw new NoSlotFoundExecption();
    }

    @Override
    public List<Slot> getSlots(String color) throws NoSlotFoundExecption {

        List<Slot> newSlots = new ArrayList<>();
        for(int i=1; i<=size; i++){
            Slot slot = slots.get(i);
            if(!slot.isEmpty()){
                Car car = slot.getParkedCar();
                if(car.getColor() == color){
                    newSlots.add(slot);
                }
            }
        }

        if(newSlots.size() > 0){
            return newSlots;
        }

       throw new NoSlotFoundExecption();
    }

    @Override
    public void addCar(Car car){

        try {

            Slot slot = slotPickingStrategy.getSlot(slots);
            slot.parkACar(car);

        } catch (ParkingLotIsFullException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeCar(Slot slot) throws NoCarFoundException{
            slot.vacateCar();
    }

    @Override
    public int getSize() {
        return slots.size();
    }
}
