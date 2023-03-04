package org.example;

public class HashMapImpl<K,V> {


   public static final int DEFAULT_SIZE = 16;
   private int capacity;
   private Entry<K,V>[] table;

   public HashMapImpl(){
       this(DEFAULT_SIZE);
   }

   public HashMapImpl(int capacity){
       this.capacity = capacity;
   }

   static class Entry<K,V>{
       private K key;
       private V value;

       private Entry<K,V> next;

       public Entry(K key, V value){
           this.key = key;
           this.value = value;
       }

       public Entry(K key, V value, Entry<K,V> next){
           this(key,value);
           this.next = next;
       }


   }

   public void put(K key, V value){

       if(key == null){
           return;
       }
       int hashCode  = getHashCode(key);

       Entry<K,V> current = table[hashCode];
       Entry<K,V> previous = null;
       Entry<K,V> newEntry = new Entry(key,value);

       if(current == null){

           table[hashCode] = newEntry;
           return;

       }else{

           while(current != null){

               if(current.key == key){
                   current.value = value;
                   return;
               }

               previous = current;
               current = current.next;

           }


       }

       previous.next = newEntry;

   }

   public V get(K key){

       if(key == null){
            return null;
       }

       int hashCode  = getHashCode(key);
       Entry<K,V> current = table[hashCode];

       if(current == null){
           return null;
       }else{

           while (current != null){

               if(current.key.equals(key)){

                   return current.value;

               }

               current = current.next;
           }


       }
       return null;

   }

   private int getHashCode(K key){

       return Math.abs(key.hashCode()) % capacity;

   }



}
