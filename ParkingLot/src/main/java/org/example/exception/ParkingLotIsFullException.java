package org.example.exception;

public class ParkingLotIsFullException extends Exception{

    public ParkingLotIsFullException(){
        super("Parking Lot Is Full");
    }
}
