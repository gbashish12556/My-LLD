package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.SeatAvailabilityStatus;
import org.example.enums.SeatType;

@Getter
@AllArgsConstructor
public class Seat {


    private String id;
    private SeatType seatType;

    private Integer price;

    @Setter
    private SeatAvailabilityStatus seatAvailabilityStatus = SeatAvailabilityStatus.AVAILABLE;


    public Seat(String id, SeatType seatType, Integer price) {
        this.id = id;
        this.seatType = seatType;
        this.price = price;
    }
}
