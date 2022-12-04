package org.example.model;

public class Cell {

    public char getCurrentChar() {
        return currentChar;
    }

    public void setCurrentChar(char currentChar) {
        this.currentChar = currentChar;
    }

    private char currentChar;
    private Cordinate cordinate;

    public Cell(Cordinate cordinate){
        this.cordinate = cordinate;
        this.currentChar = 'E';
    }

}
