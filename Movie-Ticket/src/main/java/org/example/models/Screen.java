package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.data.SeatData;
import org.example.enums.SeatAvailabilityStatus;
import org.example.exception.MovieException;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private String id;

    private SeatData seatData;

    public Screen(String id) {
        this.id = id;
        seatData = new SeatData();
    }

    public List<Seat> getAllSeats(){

        return seatData.getAllSeats();

    }
}
