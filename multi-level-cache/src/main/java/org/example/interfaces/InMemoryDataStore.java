package org.example.interfaces;

import lombok.AllArgsConstructor;
import org.example.exceptions.CacheException;
import org.example.exceptions.ExceptionType;
import org.example.response.ReadResponse;
import org.example.response.WriteResponse;

import java.util.HashMap;

@AllArgsConstructor
public class InMemoryDataStore implements CacheDataStore{

    private double size;

    private HashMap<String,String> hashMap = new HashMap<>();
    private CacheEvictor cacheEvictor;

    public InMemoryDataStore(int size, CacheEvictor cacheEvictor){
        this.size = size;
        this.cacheEvictor = cacheEvictor;
    }



    @Override
    public void writeKeyValue(String key, String value) {

        if(hashMap.size() == size){

            hashMap.remove(cacheEvictor.getEvictionKey());

        }

        cacheEvictor.keyAccess(key);

        hashMap.put(key,value);
    }

    @Override
    public String readKey(String key) throws CacheException {
        if(!hashMap.containsKey(key)){

            throw new CacheException(ExceptionType.NO_KEY_FOUND, "No Key found");
        }

        cacheEvictor.keyAccess(key);

        return hashMap.get(key);

    }

    @Override
    public void printUsage() {

        System.out.print("Usage : "+String.valueOf(hashMap.size()/size));

    }
}
