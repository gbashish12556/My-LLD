package org.example.services;

import org.example.api.PaymentApi;
import org.example.enums.PaymentStatus;
import org.example.exception.ExceptionType;
import org.example.exception.MovieException;
import org.example.models.Booking;
import org.example.models.Show;
import org.example.models.User;
import org.springframework.web.bind.annotation.PostMapping;

public class PaymentService {

    public PaymentService(Integer MAX_RETRIES){
        this.MAX_RETRIES = MAX_RETRIES;
    }
    private Integer retries = 0;
    private Integer MAX_RETRIES;
    private PaymentApi paymentApi;

    private BookingService bookingService;

    public void makeFailedPayment(Integer amount, Show show, Booking booking, User user) throws MovieException{

        if(retries >= MAX_RETRIES ){
            throw new MovieException(ExceptionType.MAX_RETRIES_EXCEEDED, "Exceeded");
        }

        PaymentStatus paymentStatus = paymentApi.makePayment(amount, user.getId());

        if(paymentStatus == PaymentStatus.FAILED){

            retries++;

        }

    }

    public void makeSuccessPayment(Integer amount, Show show, Booking booking, User user){

        bookingService.confirmBooking(show, booking.getId());

    }


}
