package org.example.interfaces;

import java.util.ArrayList;

public class LruCacheEvictor implements CacheEvictor{

    ArrayList<String> keys = new ArrayList<>();

    @Override
    public void keyAccess(String key) {

        if(keys.contains(key)){

            keys.remove(key);

        }

        keys.add(key);

    }

    @Override
    public String getEvictionKey() {

        String key =  keys.get(0);

        keys.remove(0);

        return key;
    }
}
