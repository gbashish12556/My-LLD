package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.SeatAvailabilityStatus;
import org.example.enums.SeatType;

@Getter
@AllArgsConstructor
public class Seat {
    private Integer seatNo;
    private SeatType seatType;

    @Setter
    private SeatAvailabilityStatus seatAvailabilityStatus;


}
