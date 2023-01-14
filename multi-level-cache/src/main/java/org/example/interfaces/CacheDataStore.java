package org.example.interfaces;

import org.example.exceptions.CacheException;
import org.example.response.ReadResponse;
import org.example.response.WriteResponse;

public interface CacheDataStore {

    void writeKeyValue(String key, String value);

    String readKey(String key) throws CacheException;

    void printUsage();

}
