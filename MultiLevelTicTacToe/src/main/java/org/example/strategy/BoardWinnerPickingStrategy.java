package org.example.strategy;

import org.example.model.Board;
import org.example.model.Player;

public interface BoardWinnerPickingStrategy {

    Boolean checkIfWinner(Board board, Player player);
}
