package org.example.services;

import org.example.models.Movie;
import org.example.models.Screen;
import org.example.models.Show;
import org.example.provider.SeatLockProvider;

import java.util.*;

public class ShowService {

    private HashMap<String , Show> shows = new HashMap<>();


    public void createShow(Movie movie, Screen screen, Date starTime, Long timeDuration){

        String id  = UUID.randomUUID().toString();

        shows.put(id, new Show(id, movie, screen, starTime, timeDuration));

    }

    public Show getShow(String showId){

        return shows.get(showId);
    }


    public List<Show> getAvailableShows(){

        return new ArrayList<Show>(shows.values());
    }
}
