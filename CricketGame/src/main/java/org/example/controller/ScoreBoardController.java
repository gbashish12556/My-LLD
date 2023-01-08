package org.example.controller;

import org.example.input.InputScreen;
import org.example.model.ScoreBoard;

public class ScoreBoardController {

    private InputScreen inputScreen;
    private ScoreBoard scoreBoard;

    public ScoreBoardController(InputScreen inputScreen,
                         ScoreBoard scoreBoard){

        this.inputScreen  = inputScreen;
        this.scoreBoard = scoreBoard;

    }

    public void run(){

        while(true){

            String command = inputScreen.getCommand();
            scoreBoard.updateScoreBoard(command);

        }

    }
}
