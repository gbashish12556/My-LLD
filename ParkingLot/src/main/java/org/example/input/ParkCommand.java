package org.example.input;

import org.example.exception.InvalidCommandException;
import org.example.exception.ParkingLotIsFullException;
import org.example.model.Car;
import org.example.model.Slot;
import org.example.output.OutputPrinter;
import org.example.storage.Storage;

public class ParkCommand extends Command{

    public ParkCommand(Storage storage){
        super(storage);
    }

    @Override
    public void execute(String command) throws InvalidCommandException {
        String[] params = command.split(" ");

        if(params.length != 3){
            throw new InvalidCommandException();
        }

        Car car = new Car(params[0], params[1]);
        try {

            Slot slot = getStorage().addCar(car);
            OutputPrinter.carParked(slot);

        } catch (ParkingLotIsFullException e) {

            OutputPrinter.parkingLotFull();
        }

    }

    @Override
    public String getIdentifier() {
        return "park";
    }
}
