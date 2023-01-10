package org.example.api;

import org.example.enums.PaymentStatus;
import org.springframework.web.bind.annotation.PostMapping;

public class PaymentApi {

    @PostMapping(value = "api/make_payment/{amount}/{userId}")
    public PaymentStatus makePayment(Integer amount, Integer userId){

        return PaymentStatus.SUCCESS;

    }

}
