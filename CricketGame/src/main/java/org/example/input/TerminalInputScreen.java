package org.example.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalInputScreen implements InputScreen{


    private BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

    @Override
    public String getCommand() {

        String str = "";

        try {

            str = inp.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        return str;
    }



}
