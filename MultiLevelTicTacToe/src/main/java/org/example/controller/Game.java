package org.example.controller;

import org.example.model.Board;
import org.example.model.Cordinate;
import org.example.model.Player;
import org.example.output.OutputPrinter;
import org.example.strategy.BoardPickingStrategy;
import org.example.strategy.CircularPlayerPickingStrategy;
import org.example.strategy.ExactBoardPickingStrategy;
import org.example.strategy.PlayerPickingStartegy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();
    private Board[][] boards = new Board[3][3];

    private BoardPickingStrategy boardPickingStrategy;
    private PlayerPickingStartegy playerPickingStartegy;
    private OutputPrinter outputPrinter;


    public Game(){

        intialiseBoard(3);
        initialisePlayers();
        boardPickingStrategy = new ExactBoardPickingStrategy(boards);
        playerPickingStartegy = new CircularPlayerPickingStrategy(players);
        outputPrinter = new OutputPrinter();


    }

    void run(){


        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

        Cordinate cordinate = new Cordinate(0,0);

        try {

            while(true) {

                Player currentPlayer = playerPickingStartegy.getPlayer();
                Board board = boardPickingStrategy.getBoard(cordinate);

                outputPrinter.printPlayerinfo(currentPlayer);
                outputPrinter.giveInputForBoard(board);

                String[] str = inp.readLine().split(" ");
                cordinate = new Cordinate(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                if(board.validateMove(cordinate)){

                    board.playMove(cordinate,currentPlayer.getCharacter());

                }


            }


        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    void initialisePlayers(){
        Player player1 = new Player(1, "Ashish", '0');
        Player player2 = new Player(2, "Abhi", 'X');
        players.add(player1);
        players.add(player2);
    }

    void intialiseBoard(int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                boards[i][j] = new Board(new Cordinate(i,j), size);
            }
        }
    }


}
