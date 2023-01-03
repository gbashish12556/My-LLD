package org.example.model;

import org.example.strategy.BoardWinnerPickingStrategy;
import org.example.strategy.ExactBoardWinnerStrategy;

import static java.sql.Types.NULL;

public class Board {

    public Cell[][] getCells() {
        return cells;
    }

    private Cell[][] cells;
    private int rows;
    private int columns;

    private BoardWinnerPickingStrategy boardWinnerPickingStrategy;

    public Player getWinner() {
        return winner;
    }

    private Player winner;

    public Cordinate getCordinate() {
        return cordinate;
    }

    private  Cordinate cordinate;
    public Board(Cordinate cordinate, int rows, int columns, BoardWinnerPickingStrategy boardWinnerPickingStrategy){
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];
        this.cordinate = cordinate;
        this.boardWinnerPickingStrategy = boardWinnerPickingStrategy;
        intialiseCells();
    }

    void intialiseCells(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++) {
                cells[i][j] = new Cell(new Cordinate(i,j));
            }
        }
    }

    public void playMove(Cordinate cordinate, Player player){
        cells[cordinate.getxCord()][cordinate.getyCord()].setCurrentChar(player.getCharacter());
        if(boardWinnerPickingStrategy.checkIfWinner(this, player)){
            this.winner = player;
        }

    }

    public boolean validateMove(Cordinate cordinate){
        if(winner != null){
            return false;
        }
        if(cordinate.getxCord() < 0 || cordinate.getxCord() > columns - 1 || cordinate.getyCord() < 0 || cordinate.getyCord() > rows -1){
            return false;
        }
        if(cells[cordinate.getxCord()][cordinate.getyCord()].getCurrentChar() == 'E'){
            return true;
        }
        return false;
    }
}
