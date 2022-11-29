package org.example.strategy;

import org.example.exception.ParkingLotIsFullException;
import org.example.model.Slot;

import java.util.List;

public interface SlotPickingStrategy {

    abstract Slot getSlot(List<Slot> slots) throws ParkingLotIsFullException;

}
