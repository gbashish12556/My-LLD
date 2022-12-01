package org.example.input;

import org.example.exception.InvalidCommandException;
import org.example.storage.Storage;

public abstract class Command {

    Command(Storage storage){
       this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    private Storage storage;
    public abstract void execute(String command) throws InvalidCommandException;
    public abstract String getIdentifier();

}
