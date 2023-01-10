package org.example.services;

import org.example.api.PaymentApi;
import org.example.enums.PaymentStatus;
import org.example.exception.ExceptionType;
import org.example.exception.MovieException;
import org.springframework.web.bind.annotation.PostMapping;

public class PaymentService {

    public PaymentService(Integer MAX_RETRIES){
        this.MAX_RETRIES = MAX_RETRIES;
    }
    private Integer retries = 0;
    private Integer MAX_RETRIES;
    private PaymentApi paymentApi;

    public PaymentStatus makePayment(Integer amount, Integer userId) throws MovieException{

        if(retries >= MAX_RETRIES ){
            throw new MovieException(ExceptionType.MAX_RETRIES_EXCEEDED, "Exceeded");
        }

        PaymentStatus paymentStatus = paymentApi.makePayment(amount, userId);

        if(paymentStatus == PaymentStatus.FAILED){

            retries++;

        }

        return  paymentStatus;

    }

}
