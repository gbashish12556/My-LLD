package org.example;

public class Main {
    public static void main(String[] args) {

        HashMapImpl<Integer,String> hashMap = new HashMapImpl<>(20);
        hashMap.put(21,"21");
        hashMap.put(1,"01");

        System.out.println(hashMap.get(1));

    }
}