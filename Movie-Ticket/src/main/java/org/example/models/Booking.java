package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.BookingStatus;

import java.util.List;

@AllArgsConstructor
@Getter
public class Booking {

    private String id;
    private Show show;

    private List<Seat> seats;


    @Setter
    private BookingStatus bookingStatus = BookingStatus.CREATED;

    private Integer amount;

}
