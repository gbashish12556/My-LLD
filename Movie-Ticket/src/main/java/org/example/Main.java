package org.example;

import org.example.controller.ShowController;
import org.example.models.Movie;
import org.example.models.Screen;
import org.example.services.ShowService;

import java.util.Date;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ShowController showController = new ShowController(new ShowService());

        Movie movie  = new Movie(UUID.randomUUID().toString(), "Ishq");
        Screen screen = new Screen(UUID.randomUUID().toString());

        showController.createShow(movie, screen, new Date(), 3*60*60*1000);


    }
}