package org.example.input;

import org.example.exception.InvalidCommandException;
import org.example.exception.NoCarFoundException;
import org.example.model.Car;
import org.example.output.OutputPrinter;
import org.example.storage.Storage;

public class LeaveCommand extends Command{

    public LeaveCommand(Storage storage) {
        super(storage);
    }

    @Override
    public void execute(String command) throws InvalidCommandException {

        String[] params = command.split(" ");

        if(params.length != 2){
            OutputPrinter.noCarFound();
        }

        try {

            Integer slot = Integer.parseInt(params[1]);
            getStorage().removeCar(slot);

            OutputPrinter.carRemovedFromSlot(slot);

        } catch (Exception e) {
            OutputPrinter.noCarFound();
        }

    }

    @Override
    public String getIdentifier() {
        return "leave";
    }
}
