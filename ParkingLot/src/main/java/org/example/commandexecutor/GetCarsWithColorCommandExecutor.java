package org.example.commandexecutor;

import org.example.exception.NoCarFoundException;
import org.example.model.Command;
import org.example.output.OutputPrinter;
import org.example.storage.Storage;

import java.util.List;

public class GetCarsWithColorCommandExecutor extends CommandExecutor{


    public static final String COMMAND_NAME = "registration_numbers_for_cars_with_colour";
    private OutputPrinter outputPrinter;

    public GetCarsWithColorCommandExecutor(Storage storage, OutputPrinter outputPrinter) {

        super(storage);
        this.outputPrinter = outputPrinter;

    }

    @Override
    public void execute(List<String> params) {

        try {

            outputPrinter.printAllCars(getStorage().getCarsWithColors(params.get(0)));

        } catch (NoCarFoundException e) {

            outputPrinter.noCarFound();

        }
    }

    @Override
    public boolean validate(Command command) {

        if(command.getCommandName().equals(COMMAND_NAME) && command.getParams().size() == 1){
            return true;
        }

        outputPrinter.invalidLeaveCommand();

        return false;
    }
}
