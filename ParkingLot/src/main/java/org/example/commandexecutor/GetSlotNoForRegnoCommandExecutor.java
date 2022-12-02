package org.example.commandexecutor;

import org.example.exception.NoSlotFoundExecption;
import org.example.model.Command;
import org.example.output.OutputPrinter;
import org.example.storage.Storage;

import java.util.List;

public class GetSlotNoForRegnoCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "slot_number_for_registration_number";

    private OutputPrinter outputPrinter;

    public GetSlotNoForRegnoCommandExecutor(Storage storage, OutputPrinter outputPrinter) {

        super(storage);
        this.outputPrinter = outputPrinter;

    }

    @Override
    public void execute(List<String> params) {

        try {

            outputPrinter.printSlot(getStorage().getSlot(params.get(0)));

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
