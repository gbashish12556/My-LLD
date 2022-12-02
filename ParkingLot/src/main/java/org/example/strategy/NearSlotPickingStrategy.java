package org.example.strategy;

import org.example.exception.ParkingLotIsFullException;
import org.example.model.Slot;

import java.util.List;

public class NearSlotPickingStrategy implements SlotPickingStrategy {


    public NearSlotPickingStrategy(){
    }

    @Override
    public Slot getSlot(List<Slot> slots) throws ParkingLotIsFullException {

        int size = slots.size();

        for(int i=0; i<size; i++){
            if(slots.get(i).isEmpty()){
                return slots.get(i);
            }
        }

        throw new ParkingLotIsFullException();

    }
}
