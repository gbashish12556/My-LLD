package org.example.commandexecutor;

import org.example.exception.NoCarFoundException;
import org.example.exception.NoSlotFoundExecption;
import org.example.model.Car;
import org.example.model.Command;
import org.example.model.Slot;
import org.example.output.OutputPrinter;
import org.example.storage.Storage;

import java.util.List;

public class GetSlotsWithColorCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "slot_numbers_for_cars_with_colour";

    private OutputPrinter outputPrinter;

    public GetSlotsWithColorCommandExecutor(Storage storage, OutputPrinter outputPrinter) {

        super(storage);
        this.outputPrinter = outputPrinter;

    }

    @Override
    public void execute(List<String> params) {

        try {

            outputPrinter.printAllSlots(getStorage().getSlots(params.get(0)));

        } catch (NoSlotFoundExecption e) {

            outputPrinter.noSlotFound();

        }

    }

    @Override
    public boolean validate(Command command) {

        if(command.getCommandName().equals(COMMAND_NAME) && command.getParams().size() == 1){
            return true;
        }

        outputPrinter.invalidCommand();

        return false;
    }
}
