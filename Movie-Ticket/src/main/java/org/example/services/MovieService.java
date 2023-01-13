package org.example.services;

import org.example.models.Movie;

import java.util.HashMap;
import java.util.UUID;

public class MovieService {

    HashMap<String, Movie> movies;


    void createMovie(String name){

        String id = UUID.randomUUID().toString();
        movies.put(id, new Movie(id, name));

    }
}
