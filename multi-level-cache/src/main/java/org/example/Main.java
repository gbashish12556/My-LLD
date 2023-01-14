package org.example;

import org.example.interfaces.*;
import org.example.response.ReadResponse;
import org.example.response.WriteResponse;

public class Main {
    public static void main(String[] args) {

        LevelCache levelCache2  =  new SecondLevelCache();
        LevelCache levelCache1  = new FirstLevelCache(10,5, levelCache2, new InMemoryDataStore(10, new LruCacheEvictor()));

        CacheController cacheController = new CacheController(levelCache1);

        WriteResponse writeResponse = cacheController.writeKeyValue("first","10");

        System.out.println("TotalWriteTime1 : "+String.valueOf(writeResponse.getTotalWriteTime()));

        writeResponse = cacheController.writeKeyValue("first","15");

        System.out.println("TotalWriteTime2 : "+String.valueOf(writeResponse.getTotalWriteTime()));

        ReadResponse readResponse = cacheController.readKey("first");

        System.out.println("TotalReadTime1 : "+readResponse.getValue()+" = "+readResponse.getTotalReadTime());

        readResponse = cacheController.readKey("second");

        System.out.println("TotalReadTime2 : "+readResponse.getValue()+" = "+readResponse.getTotalReadTime());




    }
}