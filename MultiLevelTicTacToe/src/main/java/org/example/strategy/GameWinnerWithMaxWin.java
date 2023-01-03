package org.example.strategy;

import org.example.model.Board;
import org.example.model.Player;

import java.util.List;

public class GameWinnerWithMaxWin implements GameWinnerPickingStrategy {
    @Override
    public Player getWinner(Board[][] boards, Player player)
    {
        int winCount = 0;
        for(int i=0;i<boards.length; i++){

            for(int j=0;j<boards[0].length;j++){

                if(boards[i][j].getWinner() != null && boards[i][j].getWinner() == player){

                    winCount++;

                }
            }

            if(winCount > 3){

                return player;

            }
        }
        return null;

    }
}
