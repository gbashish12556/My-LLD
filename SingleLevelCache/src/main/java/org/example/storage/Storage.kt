package org.example.storage

interface Storage<Value> {

    fun putValue(key:String, value:Value)
    fun getValue(key:String):Value?
    fun isCacheFull():Boolean
    fun containsKey(key:String):Boolean
    fun removeKey(key:String)

}