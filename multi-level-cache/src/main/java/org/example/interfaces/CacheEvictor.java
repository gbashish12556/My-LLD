package org.example.interfaces;

public interface CacheEvictor {

    void keyAccess(String key);

    String getEvictionKey();



}
