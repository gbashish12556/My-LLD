package org.example.data;

import org.example.enums.SeatAvailabilityStatus;
import org.example.enums.SeatType;
import org.example.exception.ExceptionType;
import org.example.exception.MovieException;
import org.example.models.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SeatData {


    private Integer rows = 10;

    private Integer columns = 10;
    private ArrayList<Seat> seats = new ArrayList<>();
    private HashMap<String, Seat> seatMapping = new HashMap();


    public SeatData(){

        intialiseSeats();

    }

    void intialiseSeats(){

        for(int i=0;i<rows; i++) {

            for (int j = 0; j < columns; j++) {

                    String id = UUID.randomUUID().toString();
                    seatMapping.put(id, new Seat(id, SeatType.NORMAL, 100));

            }
        }

    }
    public List<Seat> getAllSeats(){

        ArrayList<Seat> availableSeats = new ArrayList<>();

        for(int i=0;i<rows; i++) {

            for (int j = 0; j < columns; j++) {

                SeatAvailabilityStatus seatAvailabilityStatus = seats.get(i*columns+j).getSeatAvailabilityStatus();

                if (seatAvailabilityStatus == SeatAvailabilityStatus.AVAILABLE) {
                    availableSeats.add(seats.get(i*columns+j));
                }

            }
        }

        return availableSeats;

    }

}
