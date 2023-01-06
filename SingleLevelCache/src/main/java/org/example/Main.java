package org.example;

import org.example.controller.SingleLevelCache;
import org.example.evictionpolicy.EvictionPolicy;
import org.example.evictionpolicy.LruEvictionPolicy;
import org.example.storage.HashMapStorage;
import org.example.storage.Storage;

public class Main {
    public static void main(String[] args) {

        EvictionPolicy policy = new LruEvictionPolicy();
        Storage<String> storage = new HashMapStorage<>(10);

        SingleLevelCache<String> cache = new SingleLevelCache(policy, storage);

        cache.putValue("first","Ashish");
        cache.putValue("second","Abhi");

        System.out.println(cache.getValue("second"));


    }
}