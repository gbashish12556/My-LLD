package org.example;

import lombok.AllArgsConstructor;
import org.example.enums.PaymentStatus;
import org.example.exception.ExceptionType;
import org.example.exception.MovieException;
import org.example.models.Seat;
import org.example.models.Show;
import org.example.models.Ticket;
import org.example.services.BookingService;
import org.example.services.PaymentService;

import java.util.List;


@AllArgsConstructor
public class UserController {
    private BookingService bookingService;
    private PaymentService paymentService;


    Ticket bookTicket(Show show, List<Seat> seats, Integer usrId, Integer amount) throws MovieException{

        if(paymentService.makePayment(amount,usrId) == PaymentStatus.SUCCESS){

            return new Ticket(amount, show, seats);

        }else{

            throw new MovieException(ExceptionType.PAYMENT_FAILED, "Payment failed");

        }

    };


}
