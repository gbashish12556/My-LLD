package org.example.commandexecutor;

import org.example.exception.InvalidCommandException;
import org.example.model.Command;
import org.example.storage.Storage;

import java.util.List;

public abstract class CommandExecutor {

    CommandExecutor(Storage storage){
       this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    private Storage storage;

    public abstract void execute(List<String> params);

    public abstract boolean validate(Command command);

}
