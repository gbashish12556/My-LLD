package org.example.interfaces;

import org.example.response.ReadResponse;
import org.example.response.WriteResponse;

public class SecondLevelCache implements LevelCache{

    @Override
    public WriteResponse writeKeyValue(String key, String value) {
        return new WriteResponse(10);
    }

    @Override
    public ReadResponse readKey(String key) {
        return new ReadResponse("NA", 20);
    }

    @Override
    public void printUsage() {

        System.out.print("NoUsage");

    }
}
