package org.example.controller;

import org.example.input.InputScreen;
import org.example.input.TerminalInputScreen;
import org.example.model.Board;
import org.example.model.Cordinate;
import org.example.model.Player;
import org.example.output.OutputPrinter;
import org.example.strategy.*;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();
    private Board[][] boards = new Board[3][3];

    private BoardPickingStrategy boardPickingStrategy;
    private PlayerPickingStartegy playerPickingStartegy;
    private OutputPrinter outputPrinter;

    private GameWinnerPickingStrategy winnerPickingStrategy;

    private InputScreen inputScreen;

    private BoardWinnerPickingStrategy boardWinnerPickingStrategy;



    private int rows = 3;
    private int columns = 3;
    public Game(){

        intialiseBoard(rows,columns);
        initialisePlayers();
        boardPickingStrategy = new ExactBoardPickingStrategy(boards);
        playerPickingStartegy = new CircularPlayerPickingStrategy(players);
        outputPrinter = new OutputPrinter();
        winnerPickingStrategy = new GameWinnerWithMaxWin();
        inputScreen = new TerminalInputScreen();

        boardWinnerPickingStrategy = new ExactBoardWinnerStrategy(rows,columns);


    }


    public void run(){


        Boolean isValidMove = true;

        Board currentBoard = boardPickingStrategy.getFirstBoard();

        Player currentPlayer = null;

        Cordinate cordinate;

        try {

            while(true) {

                if(isValidMove){

                    currentPlayer = playerPickingStartegy.getPlayer();

                }

                outputPrinter.printPlayerinfo(currentPlayer);
                outputPrinter.giveInputForBoard(currentBoard);

                cordinate = inputScreen.getCordinate();

                if(currentBoard.validateMove(cordinate)){

                    currentBoard.playMove(cordinate,currentPlayer);

                    Player winner = winnerPickingStrategy.getWinner(boards,  currentPlayer);

                    if(winner != null){


                        outputPrinter.printWinnerInfo(winner);
                        return;


                    }

                    currentBoard = boardPickingStrategy.getBoard(cordinate);

                    isValidMove = true;


                }else{

                    isValidMove = false;

                }


            }


        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    void initialisePlayers(){
        Player player1 = new Player(1, "Ashish", '0');
        Player player2 = new Player(2, "Abhi", 'X');
        players.add(player1);
        players.add(player2);
    }

    void intialiseBoard(int rows, int columns){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                boards[i][j] = new Board(new Cordinate(i,j), rows, columns, boardWinnerPickingStrategy);
            }
        }
    }


}
