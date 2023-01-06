package org.example.storage

import java.util.HashMap

class HashMapStorage<Value> constructor(var size:Int) :Storage<Value> {

    var map = HashMap<String,Value>();

    override fun putValue(key: String, value: Value) {
        map.put(key,value)
    }

    override fun getValue(key: String): Value? {
        return map.get(key)
    }

    override fun isCacheFull(): Boolean {
        if (map.size >= size){
            return true;
        }
        return false;
    }

    override fun containsKey(key: String): Boolean {
        return map.containsKey(key)
    }


    override fun removeKey(key: String) {
       map.remove(key)
    }

}