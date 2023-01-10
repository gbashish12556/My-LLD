package org.example.data;

import org.example.enums.SeatAvailabilityStatus;
import org.example.exception.ExceptionType;
import org.example.exception.MovieException;
import org.example.models.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeatData {

    private Integer capacity;
    private ArrayList<Seat> seats = new ArrayList<>();
    private HashMap<Integer, Seat> seatMapping = new HashMap();


    public List<Seat> getAvailableSeats(){

        ArrayList<Seat> availableSeats = new ArrayList<>();

        for(int i=0;i<capacity; i++){

            SeatAvailabilityStatus seatAvailabilityStatus  = seats.get(i).getSeatAvailabilityStatus();

            if(seatAvailabilityStatus == SeatAvailabilityStatus.AVAILABLE){
                availableSeats.add(seats.get(i));
            }

        }

        return availableSeats;

    }

    public void temporarilyBlockSeat(List<Integer> seatNos) throws MovieException{

        int size = seatNos.size();

        for(int i=0;i<size; i++){

            Seat seat = seatMapping.get(seatNos.get(i));
            if(seat.getSeatAvailabilityStatus() == SeatAvailabilityStatus.PERMANENTLY_UNAVAILABLE
            ||seat.getSeatAvailabilityStatus() == SeatAvailabilityStatus.TEMPORARILY_UNAVAILABLE){

                throw new MovieException(ExceptionType.SEAT_TEMPORARILY_UNAVAILABLE, "Not Available");

            }

            seat.setSeatAvailabilityStatus(SeatAvailabilityStatus.TEMPORARILY_UNAVAILABLE);

        }

    }

    public void permanentlyBlockSeats(List<Integer> seatNos) throws MovieException{

        int size = seatNos.size();

        for(int i=0;i<size; i++){

            Seat seat = seatMapping.get(seatNos.get(i));
            if(seat.getSeatAvailabilityStatus() == SeatAvailabilityStatus.PERMANENTLY_UNAVAILABLE
                    ||seat.getSeatAvailabilityStatus() == SeatAvailabilityStatus.TEMPORARILY_UNAVAILABLE){

                throw new MovieException(ExceptionType.SEAT_TEMPORARILY_UNAVAILABLE, "Not Available");

            }

            seat.setSeatAvailabilityStatus(SeatAvailabilityStatus.TEMPORARILY_UNAVAILABLE);

        }

    }

}
