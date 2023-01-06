package org.example.evictionpolicy

interface EvictionPolicy {


    fun keyAccessed(key:String)
    fun getEvictKey():String


}