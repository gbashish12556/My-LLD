package org.example.strategy;

import org.example.model.Board;
import org.example.model.Cordinate;

public interface BoardPickingStrategy {

    Board getBoard(Cordinate cordinate);

    Board getFirstBoard();


}
