package org.example.controller

import org.example.evictionpolicy.EvictionPolicy
import org.example.storage.Storage

class SingleLevelCache<Value>  {

    lateinit var evictionPolicy: EvictionPolicy;
    lateinit var storage: Storage<Value>

    constructor(evictionPolicy: EvictionPolicy, storage: Storage<Value>){
            this.evictionPolicy = evictionPolicy;
            this.storage = storage
    }

    fun putValue(key:String, value:Value){

        if (storage.isCacheFull()){

            storage.removeKey(evictionPolicy.getEvictKey())

        }

        storage.putValue(key, value)

    }

    fun getValue(key:String):Value? {

        if(storage.containsKey(key)){

            evictionPolicy.keyAccessed(key)

            return storage.getValue(key)

        }

        return null

    }

}