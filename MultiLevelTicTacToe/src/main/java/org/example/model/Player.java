package org.example.model;

public class Player {

    private int id;

    public String getName() {
        return name;
    }

    private String name;

    public char getCharacter() {
        return character;
    }

    private char character;

    public Player(int id, String name, char character){
        this.id = id;
        this.name = name;
        this.character = character;
    }

}
