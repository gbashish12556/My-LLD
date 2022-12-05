package org.example;

import org.example.controller.Remote;
import org.example.model.DogDoor;

public class Main {
    public static void main(String[] args) {

        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);
        System.out.println("Dog barks to go outside");
        remote.pressButton();
        System.out.println("Dog is outside");
        remote.pressButton();
        System.out.println("Dog is in");

    }
}