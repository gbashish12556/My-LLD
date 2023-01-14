package org.example;

import lombok.AllArgsConstructor;
import org.example.interfaces.LevelCache;
import org.example.response.ReadResponse;
import org.example.response.WriteResponse;

@AllArgsConstructor
public class CacheController {

    private LevelCache levelCache;

    public WriteResponse writeKeyValue(String key, String value){
        return levelCache.writeKeyValue(key,value);
    }

    public ReadResponse readKey(String key){
        return levelCache.readKey(key);
    }


}
