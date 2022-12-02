package org.example.commandexecutor;

import org.example.exception.InvalidCommandException;
import org.example.model.Command;
import org.example.output.OutputPrinter;
import org.example.storage.Storage;

import java.util.List;

public class LeaveCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "leave";
    private OutputPrinter outputPrinter;

    public LeaveCommandExecutor(Storage storage, OutputPrinter outputPrinter) {

        super(storage);
        this.outputPrinter = outputPrinter;

    }

    @Override
    public void execute(List<String> params) {

        try {

            Integer slot = Integer.parseInt(params.get(0));

            getStorage().removeCar(slot);

            outputPrinter.carRemovedFromSlot(slot);

        } catch (Exception e) {

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
