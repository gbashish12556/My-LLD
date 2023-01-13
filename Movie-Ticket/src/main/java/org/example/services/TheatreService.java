package org.example.services;

import org.example.models.Screen;
import org.example.models.Theatre;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TheatreService {

    HashMap<String, Theatre> theatres = new HashMap<>();


    void createTheatre(String name){

        String id = UUID.randomUUID().toString();
        theatres.put(id, new Theatre(id, name));


    }

    List<Screen> getScreens(String theatreId){

        return theatres.get(theatreId).getScreens();

    }



}
