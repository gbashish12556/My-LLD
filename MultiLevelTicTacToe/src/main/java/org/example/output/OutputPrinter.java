package org.example.output;

import org.example.model.Board;
import org.example.model.Player;

import java.util.Optional;

public class OutputPrinter {

    public OutputPrinter(){

    }

    public void giveInputForBoard(Board board){
        print("Give input for board "+String.valueOf(board.getCordinate().getxCord())+", "+String.valueOf(board.getCordinate().getyCord()));
    }

    public void printPlayerinfo(Player player){
        print("Player Name : "+String.valueOf(player.getName()));
    }

    public void printWinnerInfo(Player player){
        print("Winner Is:");
        printPlayerinfo(player);
    }

    public void invalidMove(){

        System.out.println("Invalid Move");

    }

    void print(String str){
        System.out.println(str);
    }

}
