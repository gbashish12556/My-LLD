package org.example.services;

import lombok.AllArgsConstructor;
import org.example.enums.BookingStatus;
import org.example.exception.ExceptionType;
import org.example.exception.MovieException;
import org.example.models.Booking;
import org.example.models.Seat;
import org.example.models.Show;
import org.example.provider.SeatLockProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Handler;

@AllArgsConstructor
public class BookingService {


    private Integer maxTicketSize;
    private HashMap<Show , HashMap<String,Booking>> bookings;

    private SeatLockProvider seatLockProvider;


    public void createBooking(List<Seat> seats, Show show) throws MovieException {

        if(anySeatAlreadyBooked(show, seats)){

            throw new MovieException(ExceptionType.SEATS_ALREADY_BOOKED, "Already booked");

        }

        String id = UUID.randomUUID().toString();
        Booking booking = new Booking(id, show, seats, BookingStatus.CREATED, 2000);

        bookings.get(show).put(id, booking);

        (new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(10000);
                    if(booking.getBookingStatus() == BookingStatus.CREATED){

                        bookings.get(show).remove(id);


                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        })).start();

    }

    public void confirmBooking(Show show, String bookingId){

        if(bookings.containsKey(show) && bookings.get(show).containsKey(bookingId)) {

            Booking booking = bookings.get(show).remove(bookingId);

            booking.setBookingStatus(BookingStatus.BOOKED);

        }

    }
    boolean anySeatAlreadyBooked(Show show, List<Seat> seats){

        ArrayList<Booking> books = new ArrayList<>(bookings.get(show).values());
        int size = books.size();

        for(int j=0;j<seats.size(); j++) {

            for (int i = 0; i < size; i++) {

                if(books.get(i).getSeats().contains(seats.get(j))){

                    return true;

                }

            }

        }

        return false;
    }


}
