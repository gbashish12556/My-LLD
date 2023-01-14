package org.example.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.exceptions.CacheException;
import org.example.response.ReadResponse;
import org.example.response.WriteResponse;


@AllArgsConstructor
@Getter
public class FirstLevelCache implements LevelCache{

    private Integer readTime;

    private Integer writeTime;

    private LevelCache nextLevelCache;

    private CacheDataStore cacheDataStore;


    @Override
    public WriteResponse writeKeyValue(String key, String value) {

        try {

            String valueFound = cacheDataStore.readKey(key);
            if(valueFound.equals(value)){

                return new WriteResponse(readTime);

            }else{

                cacheDataStore.writeKeyValue(key,value);
                WriteResponse response = nextLevelCache.writeKeyValue(key, value);

                return new WriteResponse(readTime + writeTime + response.getTotalWriteTime());
            }

        } catch (CacheException e) {

            cacheDataStore.writeKeyValue(key,value);
            WriteResponse response = nextLevelCache.writeKeyValue(key, value);

            return new WriteResponse(readTime + writeTime + response.getTotalWriteTime());

        }

    }

    @Override
    public ReadResponse readKey(String key) {

        try {

            String value =  cacheDataStore.readKey(key);

            return new ReadResponse(value, readTime);

        }catch (CacheException cacheException){

            ReadResponse readResponse = nextLevelCache.readKey(key);


            cacheDataStore.writeKeyValue(key,readResponse.getValue());


            return new ReadResponse(readResponse.getValue(), readResponse.getTotalReadTime() + readTime + writeTime);

        }

    }

    @Override
    public void printUsage() {

        cacheDataStore.printUsage();
        nextLevelCache.printUsage();

    }
}
