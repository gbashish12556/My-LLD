package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private List<Player> players = new ArrayList<>();

    private Player currentPlayer;
    private Player nonStrikePlayer;

    private int runningBall = 1;

    private int wideBalls = 0;

    private int overs = 0;
    private int noBalls;

    public ScoreBoard(){

        intialiseTeam();

    }

    private void intialiseTeam(){

        for(int i=1; i<= 11;i++){

            players.add(new Player(i, "Player"+String.valueOf(i)));

        }

        currentPlayer = players.get(0);
        nonStrikePlayer = players.get(1);
        currentPlayer.setPlayerStatus(PlayerStatus.PLAYING);
        nonStrikePlayer.setPlayerStatus(PlayerStatus.PLAYING);

    }

    public void updateScoreBoard(String command){

        String[] params  = command.split(" ");

        Integer score = 0;

        if(params[0].contains("WIDEBALL") || params[0].contains("NOBALL")){

            switch (params[0]){
                case "WIDEBALL":
                    wideBalls++;
                    break;
                case "NOBALL":
                    noBalls++;
                    break;
            }

            currentPlayer.additionalRun(1);

        }else if(params[0].contains("OUT")){

            currentPlayer.setPlayerStatus(PlayerStatus.OUT);
            currentPlayer = getNextPlayer();


        } else if(params[0].contains("RUNOUT")){

            Integer playerNo = Integer.parseInt(params[1]);

            if(currentPlayer.getPlayerNo() == playerNo) {

                currentPlayer.setPlayerStatus(PlayerStatus.OUT);
                currentPlayer = getNextPlayer();

            }else {

                nonStrikePlayer.setPlayerStatus(PlayerStatus.OUT);
                nonStrikePlayer = getNextPlayer();

            }

            runningBall++;

        }else if(params[0].contains("SCORE")){

            score = Integer.parseInt(params[1]);
            currentPlayer.increaseScore(score);
            runningBall++;

        }

        if(runningBall%6 == 1 || score%2 == 1){

            overs++;
            Player temp = currentPlayer;
            currentPlayer = nonStrikePlayer;
            nonStrikePlayer = temp;

        }

        displayUpdatedList();

    }

    void displayUpdatedList(){

        System.out.println("Player\tRun\tBallsFaced\tSixes\tFours\tStatus");
        for(int i=0;i<11;i++){

            if(players.get(i).getPlayerStatus() != PlayerStatus.YET_TO_PLAY){
                Player player = players.get(i);
                System.out.println(player.getName()+"\t"+player.getScore()+"\t"+player.getBallsFace()+"\t\t\t"+player.getSixes()+"\t\t"+player.getFours()+"\t\t"+player.getPlayerStatus().toString());
            }
        }
    }

    Player getNextPlayer(){

        for(int i=0;i<11;i++){

            if(players.get(i).getPlayerStatus().equals(PlayerStatus.YET_TO_PLAY)){
                players.get(i).setPlayerStatus(PlayerStatus.PLAYING);
                return  players.get(i);
            }

        }

        return null;

    }



}
