package org.example.strategy.interfaces;

import org.example.model.Board;
import org.example.model.Player;

import java.util.List;

public interface GameWinnerPickingStrategy {

    Player getWinner(Board[][] boards, Player player);
}
