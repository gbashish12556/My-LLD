package org.example.input;

import org.example.exception.InvalidCommandException;
import org.example.storage.ParkingLot;
import org.example.storage.Storage;

import java.util.List;

abstract class Command {

    Command(Storage storage){
       this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    private Storage storage;
    abstract void execute(String command) throws InvalidCommandException;
    abstract String getIdentifier();

}
