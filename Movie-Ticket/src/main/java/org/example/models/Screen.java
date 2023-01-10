package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.data.SeatData;
import org.example.enums.SeatAvailabilityStatus;
import org.example.exception.MovieException;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Screen {

    private Integer screenNo;

    private SeatData seatData;

    public List<Seat> getAvailableSeats(){

        return seatData.getAvailableSeats();

    }

    public void temporarilyBlockSeat(List<Integer> seatNos) throws MovieException {

        seatData.temporarilyBlockSeat(seatNos);

    }

    public void permanantlyBlockSeats(List<Integer> seatNos) throws MovieException {

        seatData.temporarilyBlockSeat(seatNos);

    }
}
