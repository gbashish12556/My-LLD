package org.example.services;

import lombok.AllArgsConstructor;
import org.example.exception.ExceptionType;
import org.example.exception.MovieException;
import org.example.models.Seat;
import org.example.models.Show;

import java.util.List;

@AllArgsConstructor
public class BookingService {


    private Integer maxTicketSize;
    private Show show;


    public List<Seat> getAvailableSeats(){

        return  show.getScreen().getAvailableSeats();

    }

    public void blockSeatsTemporarily(List<Integer> seatNos) throws MovieException {


        if (seatNos.size() >= maxTicketSize) {

            throw new MovieException(ExceptionType.SEAT_LIMIT_EXCEEDED, "Exceeded");

        }

        show.getScreen().temporarilyBlockSeat(seatNos);

    }

    public void blockSeatsPermanantly(List<Integer> seatNos) throws MovieException {


        if (seatNos.size() >= maxTicketSize) {

            throw new MovieException(ExceptionType.SEAT_LIMIT_EXCEEDED, "Exceeded");

        }

        show.getScreen().temporarilyBlockSeat(seatNos);

    }

}
