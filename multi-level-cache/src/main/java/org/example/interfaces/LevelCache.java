package org.example.interfaces;

import org.example.exceptions.CacheException;
import org.example.response.ReadResponse;
import org.example.response.WriteResponse;

public interface LevelCache {

    WriteResponse writeKeyValue(String key, String value);

    ReadResponse readKey(String key);

    void printUsage();

}
