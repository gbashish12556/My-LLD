package org.example.output;

import org.example.model.Slot;
import org.example.model.Ticket;

public class OutputPrinter {


    public static void invalidCommand(){
        System.out.println("This is an invalid command");
    }

    public static void noCarFound(){
        System.out.println("No car found for the given command");
    }

    public static void parkingLotFull(){
        System.out.println("Parking lot has no space to accomodate the car");
    }

    public static void carRemovedFromSlot(int slotNo){
        System.out.println("Car removed from slot "+String.valueOf(slotNo));
    }

    public static void carParked(Ticket ticket){
        System.out.println("TicketNo : "+ticket.getId()+", Car "+String.valueOf(ticket.getCar().getRegistrationNo())+"parked in slot "+String.valueOf(ticket.getSlot().getSlotNo()));
    }


}
