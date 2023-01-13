package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.models.Movie;
import org.example.models.Screen;
import org.example.models.Show;
import org.example.services.ShowService;

import java.util.Date;

@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    public void createShow(Movie movie, Screen screen, Date starTime, Long timeDuration){

        showService.createShow(movie, screen, starTime, timeDuration);

    }


}
