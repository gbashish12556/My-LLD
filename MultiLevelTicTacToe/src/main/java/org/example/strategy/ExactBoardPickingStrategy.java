package org.example.strategy;

import org.example.model.Board;
import org.example.model.Cordinate;

public class ExactBoardPickingStrategy implements BoardPickingStrategy{

    private Board[][] boards;

    public ExactBoardPickingStrategy(Board[][] boards){
        this.boards = boards;
    }

    @Override
    public Board getBoard(Cordinate cordinate) {
        return boards[cordinate.getxCord()][cordinate.getyCord()];
    }
}
