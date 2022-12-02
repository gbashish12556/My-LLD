package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {


    private String commandName;
    private List<String> params;

    public Command(String str){
        parseData(str);
    }

    void parseData(String str){

        params = new ArrayList(Arrays.asList( str.split(" ")));

        commandName = params.get(0).trim();

        params.remove(0);


    }


    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }


}
