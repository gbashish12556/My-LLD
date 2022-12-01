package org.example.controller;

import org.example.input.CommandInputScreen;
import org.example.storage.ParkingLotStorage;
import org.example.storage.Storage;
import org.example.strategy.NearSlotPickingStrategy;

public class ParkingLot {

    public static void open(){

        Storage parkingLotStorage = new ParkingLotStorage(10, new NearSlotPickingStrategy());
        CommandInputScreen inputScreen = new CommandInputScreen(parkingLotStorage);
        inputScreen.run();

    };

}
