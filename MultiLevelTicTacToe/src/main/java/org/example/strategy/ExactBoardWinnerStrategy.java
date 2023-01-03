package org.example.strategy;

import org.example.model.Board;
import org.example.model.Cell;
import org.example.model.Player;

public class ExactBoardWinnerStrategy implements BoardWinnerPickingStrategy{


    private int rows;
    private int columns;

    public ExactBoardWinnerStrategy(int rows, int columns){

        this.rows  = rows;
        this.columns  = columns;

    }

    @Override
    public Boolean checkIfWinner(Board board, Player player) {

        return horizontalRowsFilled(board, player.getCharacter())
                || verticalColumnsFilled(board, player.getCharacter())|| diagonalsFilled(board, player.getCharacter());

    }

    Boolean horizontalRowsFilled(Board board, char character){

        Cell[][] cells = board.getCells();
        Boolean filled = false;
        for(int i=0;i<rows; i++){
            filled = filled || horizontalRowFilled(cells[i], character);
        }

        return filled;
    }

    Boolean verticalColumnsFilled(Board board,   char character){

        Cell[][] cells = board.getCells();
        Boolean filled = true;

        for(int i=0;i<columns;i++){

            filled = filled || verticalColumnFilled(i, cells, character);

        }

        return filled;

    }


    Boolean horizontalRowFilled(Cell[] horizontalsCells, char character){

        Boolean filled = true;
        for(int i=0;i<columns;i++){

            filled = filled && (horizontalsCells[i].getCurrentChar() == character);

        }

        return filled;
    }

    Boolean verticalColumnFilled(int columnNo, Cell[][] cells,   char character){

        Boolean filled = true;
        for(int i=0;i<rows;i++){
            filled = filled && (cells[i][columnNo].getCurrentChar() == character);
        }
        return filled;
    }


    Boolean diagonalsFilled(Board board, char character){

        return false;
    }

}
