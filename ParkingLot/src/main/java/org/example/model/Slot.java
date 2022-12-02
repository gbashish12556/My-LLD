package org.example.model;

import org.example.exception.NoCarFoundException;

import java.awt.desktop.SystemEventListener;

public class Slot {

    public int getSlotNo() {
        return slotNo;
    }

    private int slotNo;

    public Car getParkedCar() {
        return parkedCar;
    }

    private Car parkedCar;

    private boolean isEmpty;

    public Slot(int slotNo){
        this.slotNo = slotNo;
        this.isEmpty = true;
    }
    public boolean isEmpty() {
        return isEmpty;
    }


    public void parkACar(Car car){
        System.out.println("parking "+car.getRegistrationNo()+" slot "+String.valueOf(slotNo));
        this.parkedCar = car;
        this.isEmpty = false;
    }

    public void vacateCar() throws NoCarFoundException{
        System.out.println("isEmpty : "+String.valueOf(this.isEmpty));
        if(!this.isEmpty) {
            this.parkedCar = null;
            this.isEmpty = true;
        }else{
            throw new NoCarFoundException();
        }
    }
}
