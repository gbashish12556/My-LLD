package org.example.strategy;

import org.example.model.Board;
import org.example.model.Cordinate;
import org.example.strategy.interfaces.BoardPickingStrategy;

public class ExactBoardPickingStrategy implements BoardPickingStrategy {

    private Board[][] boards;

    public ExactBoardPickingStrategy(Board[][] boards){
        this.boards = boards;
    }

    @Override
    public Board getBoard(Cordinate cordinate) {

        if(cordinate == null){
            return boards[0][0];
        }

        Board board =  boards[cordinate.getxCord()][cordinate.getyCord()];


        if(board.getWinner() == null){
            return  board;
        }

        int rows = boards.length;
        int columns = boards[0].length;

        for(int i=0;i<rows; i++){

            for(int j=0;j<columns; j++) {

                if(boards[i][j].getWinner() == null){

                    return boards[i][j];

                }

            }


        }

        return  null;
    }

    @Override
    public Board getFirstBoard() {
        return boards[0][0];
    }
}
