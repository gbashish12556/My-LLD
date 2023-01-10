package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Show {
    private Movie movie;
    private String startTime;

    private Integer durationInMinutes;


    private Screen screen;


}
