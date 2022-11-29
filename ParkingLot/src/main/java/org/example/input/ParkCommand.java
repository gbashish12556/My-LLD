package org.example.input;

import org.example.exception.InvalidCommandException;
import org.example.model.Car;
import org.example.storage.ParkingLot;
import org.example.storage.Storage;

public class ParkCommand extends Command{

    ParkCommand(Storage storage){
        super(storage);
    }

    @Override
    void execute(String command) throws InvalidCommandException {
        String[] params = command.split(" ");

        if(params.length != 3){
            throw new InvalidCommandException();
        }

        Car car = new Car(params[0], params[1]);
        getStorage().addCar(car);

    }

    @Override
    String getIdentifier() {
        return "park";
    }
}
