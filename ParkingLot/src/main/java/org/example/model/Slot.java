package org.example.model;

import org.example.exception.NoCarFoundException;

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
    }
    public boolean isEmpty() {
        return isEmpty;
    }


    public void parkACar(Car car){
        this.parkedCar = car;
        this.isEmpty = false;
    }

    public void vacateCar() throws NoCarFoundException{
        if(!this.isEmpty) {
            this.parkedCar = null;
            this.isEmpty = true;
        }else{
            throw new NoCarFoundException();
        }
    }
}
