package org.example.evictionpolicy

import java.util.ArrayList

class LruEvictionPolicy:EvictionPolicy {

    var list = ArrayList<String>()

    override fun keyAccessed(key: String) {
        if(list.contains(key)){
            list.remove(key)
        }
        list.add(key)
    }

    override fun getEvictKey(): String {

        var key = list.get(0)
        list.remove(key);
        return key

    }
}