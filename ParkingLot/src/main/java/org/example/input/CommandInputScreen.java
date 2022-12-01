package org.example.input;

import org.example.exception.InvalidCommandException;
import org.example.factory.CommandFactory;
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

            String str = inp.readLine(); // for taking a string as an input
            List<Command> commands = CommandFactory.getCommands(storage);
            int size = commands.size();

            for(int i=0;i<size;i++){

                Command command = commands.get(i);

                if(str.contains(command.getIdentifier())){
                    try {
                        command.execute(str);
                    } catch (InvalidCommandException e) {
                        throw new RuntimeException(e);
                    }
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
