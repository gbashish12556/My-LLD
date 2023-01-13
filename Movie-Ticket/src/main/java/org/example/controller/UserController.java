package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.enums.PaymentStatus;
import org.example.exception.ExceptionType;
import org.example.exception.MovieException;
import org.example.models.*;
import org.example.services.BookingService;
import org.example.services.PaymentService;
import org.example.services.ShowService;

import java.util.List;


@AllArgsConstructor
public class UserController {

    private PaymentService paymentService;

    private ShowService showService;

    private BookingService bookingService;


    void makePayment(Integer amount, Show show, Booking booking, User user) {

        paymentService.makeSuccessPayment(amount,show, booking, user);

    }

    void makeFailedPayment(Integer amount, Show show, Booking booking, User user) throws MovieException {

        paymentService.makeFailedPayment(amount,show, booking, user);

    }

    List<Show> getShows(){

        return showService.getAvailableShows();
    }

    public void createBooking(List<Seat> seats, Show show) throws MovieException {

        bookingService.createBooking(seats,show);

    }

}
