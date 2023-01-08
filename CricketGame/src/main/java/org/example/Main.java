package org.example;

import org.example.controller.ScoreBoardController;
import org.example.input.InputScreen;
import org.example.input.TerminalInputScreen;
import org.example.model.ScoreBoard;

public class Main {

    public static void main(String[] args) {

        InputScreen terminalInputScreen = new TerminalInputScreen();
        ScoreBoard scoreBoard =  new ScoreBoard();
        ScoreBoardController scoreBoardController = new ScoreBoardController(terminalInputScreen, scoreBoard);
        scoreBoardController.run();

    }
}