package org.example.input;

import org.example.model.Cordinate;
import org.example.output.OutputPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalInputScreen implements InputScreen{

     private BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));


    @Override
    public Cordinate getCordinate() {


        Cordinate cordinate;
        String[] str = new String[0];

        try {

            str = inp.readLine().split(" ");
            cordinate = new Cordinate(Integer.parseInt(str[0]), Integer.parseInt(str[1]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return  cordinate;
    }
}
