package org.example.input;

import org.example.exception.InvalidCommandException;
import org.example.storage.Storage;

public class LeaveCommand extends Command{

    LeaveCommand(Storage storage) {
        super(storage);
    }

    @Override
    void execute(String command) throws InvalidCommandException {

    }

    @Override
    String getIdentifier() {
        return null;
    }
}
