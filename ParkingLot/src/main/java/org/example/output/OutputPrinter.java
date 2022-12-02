package org.example.output;

import org.example.model.Car;
import org.example.model.Slot;
import org.example.model.Ticket;

import java.util.List;

public class OutputPrinter {


    public OutputPrinter(){

    }

    public void invalidCommand(){
        System.out.println("This is an invalid command");
    }

    public void noCarFound(){
        System.out.println("No car found for the given command");
    }

    public void parkingLotFull(){
        System.out.println("Parking lot has no space to accomodate the car");
    }

    public void carRemovedFromSlot(int slotNo){
        System.out.println("Car removed from slot "+String.valueOf(slotNo));
    }

    public void carParked(Ticket ticket){
        System.out.println("TicketNo : "+ticket.getId()+", Car "+String.valueOf(ticket.getCar().getRegistrationNo())+" parked in slot "+String.valueOf(ticket.getSlot().getSlotNo()));
    }

    public void invalidLeaveCommand(){
        System.out.println("Invalid leave command");
    }

    public void invalidParkCommand(){
        System.out.println("Invalid park command");
    }

    public void noSlotFound(){
        System.out.println("No slot found");
    }


    public void printAllSlots(List<Slot> slots){

        int size = slots.size();

        for(int i=0; i<size; i++){

            System.out.println(String.valueOf(slots.get(i).getSlotNo())+"\t");
        }

    }

    public void printSlot(Slot slot){

            System.out.println(String.valueOf("Slot : \t"+slot.getSlotNo()));

    }

    public void printAllCars(List<Car> cars){

        System.out.println("Registration No\t\tColor");

        int size = cars.size();

        for(int i=0; i<size; i++){

            System.out.println(cars.get(i).getRegistrationNo()+"\t\t\t\t"+cars.get(i).getColor());

        }

    }



}
