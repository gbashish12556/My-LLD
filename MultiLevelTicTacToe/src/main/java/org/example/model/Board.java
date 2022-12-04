package org.example.model;

import static java.sql.Types.NULL;

public class Board {

    private Cell[][] cells;
    private int boardSize;

    private Player winner;

    public Cordinate getCordinate() {
        return cordinate;
    }

    private  Cordinate cordinate;
    public Board(Cordinate cordinate, int boardSize){
        this.boardSize = boardSize;
        cells = new Cell[boardSize][boardSize];
        this.cordinate = cordinate;
        intialiseCells();
    }

    void intialiseCells(){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++) {
                cells[i][j] = new Cell(new Cordinate(i,j));
            }
        }
    }

    public void playMove(Cordinate cordinate, char character){
        cells[cordinate.getxCord()][cordinate.getyCord()].setCurrentChar(character);
    }

    public boolean validateMove(Cordinate cordinate){
        if(winner != null){
            return false;
        }
        if(cordinate.getxCord() < 0 || cordinate.getxCord() > boardSize - 1 || cordinate.getyCord() < 0 || cordinate.getyCord() > boardSize -1){
            return false;
        }
        if(cells[cordinate.getxCord()][cordinate.getyCord()].getCurrentChar() == 'E'){
            return true;
        }
        return false;
    }
}
