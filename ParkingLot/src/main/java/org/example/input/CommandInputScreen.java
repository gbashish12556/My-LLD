package org.example.input;

import org.example.commandexecutor.CommandExecutor;
import org.example.exception.InvalidCommandException;
import org.example.factory.CommandFactory;
import org.example.model.Command;
import org.example.storage.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CommandInputScreen implements InputScreen{


    private Storage storage;

    public CommandInputScreen(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {

        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

        try {

            while(true) {

                String str = inp.readLine(); // for taking a string as an input
                Command command = new Command(str);
                CommandFactory commandFactory = new CommandFactory(storage);
                CommandExecutor executor = commandFactory.getCommands().get(command.getCommandName());

                if(executor.validate(command)){
                    executor.execute(command.getParams());
                }

            }


        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}
