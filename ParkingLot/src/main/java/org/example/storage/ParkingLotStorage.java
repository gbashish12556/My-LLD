package org.example.storage;

import org.example.exception.NoCarFoundException;
import org.example.exception.NoSlotFoundExecption;
import org.example.exception.ParkingLotIsFullException;
import org.example.model.Car;
import org.example.model.Slot;
import org.example.model.Ticket;
import org.example.strategy.SlotPickingStrategy;
import org.example.strategy.TicketIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotStorage implements Storage{

     private int size;
     private ArrayList<Slot> slots = new ArrayList<>();
     private SlotPickingStrategy slotPickingStrategy;

     private TicketIdGenerator ticketIdGenerator;

     public ParkingLotStorage(int size, SlotPickingStrategy slotPickingStrategy, TicketIdGenerator ticketIdGenerator){

         this.size = size;
         this.slotPickingStrategy = slotPickingStrategy;
         this.ticketIdGenerator = ticketIdGenerator;

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
        for(int i=0; i<size; i++){
            Slot slot = slots.get(i);
            if(!slot.isEmpty()){
                Car car = slot.getParkedCar();
                if(car.getColor().equals(color)){
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

        for(int i=0; i<size; i++){
            Slot slot = slots.get(i);
            if(!slot.isEmpty()){
                Car car = slot.getParkedCar();
                if(car.getRegistrationNo().equals(regNo)){
                   return slot;
                }
            }
        }

        throw new NoSlotFoundExecption();
    }

    @Override
    public List<Slot> getSlots(String color) throws NoSlotFoundExecption {

        List<Slot> newSlots = new ArrayList<>();
        for(int i=0; i<size; i++){
            Slot slot = slots.get(i);
            if(!slot.isEmpty()){
                Car car = slot.getParkedCar();
                if(car.getColor().equals(color)){
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
    public Ticket addCar(Car car) throws ParkingLotIsFullException{

            Slot slot = slotPickingStrategy.getSlot(slots);
            slot.parkACar(car);
            Ticket ticket = new Ticket(ticketIdGenerator.getTicketNo(), car, slot);
            return ticket;

    }

    @Override
    public void removeCar(Slot slot) throws NoCarFoundException{
            slot.vacateCar();
    }

    @Override
    public void removeCar(int slotNo) throws NoCarFoundException {
        for(int i=1; i <= size; i++) {

            Slot slot = slots.get(i);

           if(slot.getSlotNo() == slotNo){
                slot.vacateCar();
                return;
            }
        }
    }

    @Override
    public int getSize() {
        return slots.size();
    }
}
