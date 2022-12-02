package org.example.factory;

import org.example.commandexecutor.*;
import org.example.output.OutputPrinter;
import org.example.storage.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandFactory
{

    Map<String, CommandExecutor> commandList = new HashMap<>();

    public CommandFactory(Storage storage){

        OutputPrinter printer = new OutputPrinter();

        commandList.put(ParkCommandExecutor.COMMAND_NAME, new ParkCommandExecutor(storage, printer));
        commandList.put(LeaveCommandExecutor.COMMAND_NAME, new LeaveCommandExecutor(storage, printer));
        commandList.put(GetSlotsWithColorCommandExecutor.COMMAND_NAME, new GetSlotsWithColorCommandExecutor(storage, printer));
        commandList.put(GetCarsWithColorCommandExecutor.COMMAND_NAME, new GetCarsWithColorCommandExecutor(storage, printer));
        commandList.put(GetSlotNoForRegnoCommandExecutor.COMMAND_NAME, new GetSlotNoForRegnoCommandExecutor(storage, printer));

    }
    public  Map<String, CommandExecutor> getCommands(){


        return commandList;
    }

}
