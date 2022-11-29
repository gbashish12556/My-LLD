package org.example.strategy;

import org.example.exception.ParkingLotIsFullException;
import org.example.model.Slot;
import org.example.storage.ParkingLot;

import java.util.List;

public class NearSlotPicking implements SlotPickingStrategy {

    private ParkingLot parkingLot;
    NearSlotPicking(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    @Override
    public Slot getSlot(List<Slot> slots) throws ParkingLotIsFullException {
        int size = parkingLot.getSize();
        for(int i=0; i<size; i++){
            if(slots.get(i).isEmpty()){
                return slots.get(i);
            }
        }
        throw new ParkingLotIsFullException();
    }
}
