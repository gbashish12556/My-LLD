package org.example.factory;

import org.example.input.Command;
import org.example.input.LeaveCommand;
import org.example.input.ParkCommand;
import org.example.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory
{
    public static List<Command> getCommands(Storage storage){

        ArrayList<Command> commandList = new ArrayList<>();

        commandList.add(new ParkCommand(storage));
        commandList.add(new LeaveCommand(storage));

        return commandList;
    }

}
