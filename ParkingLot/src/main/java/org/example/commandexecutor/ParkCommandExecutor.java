package org.example.commandexecutor;

import org.example.exception.InvalidCommandException;
import org.example.exception.ParkingLotIsFullException;
import org.example.model.Car;
import org.example.model.Command;
import org.example.model.Ticket;
import org.example.output.OutputPrinter;
import org.example.storage.Storage;

import java.util.List;

public class ParkCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "park";
    private OutputPrinter outputPrinter;

    public ParkCommandExecutor(Storage storage, OutputPrinter outputPrinter){
        super(storage);
        this.outputPrinter = outputPrinter;
    }

    @Override
    public void execute(List<String> params) {

        Car car = new Car(params.get(0), params.get(1));
        try {

            Ticket ticket = getStorage().addCar(car);
            outputPrinter.carParked(ticket);

        } catch (ParkingLotIsFullException e) {

            outputPrinter.parkingLotFull();
        }

    }

    @Override
    public boolean validate(Command command){

        if(command.getCommandName().equals(COMMAND_NAME) && command.getParams().size() == 2){
            return true;
        }

        outputPrinter.invalidParkCommand();

        return false;
    }

}
