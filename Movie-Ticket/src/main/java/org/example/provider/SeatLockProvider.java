package org.example.provider;

import org.example.models.Seat;
import org.example.models.Show;
import org.example.models.User;

import java.util.List;

public interface SeatLockProvider {


    void lockSeat(Show show, Seat seat, User user);
    boolean isSeatLocked(Show show, Seat seat, User user);

    void unLockSeat(Show show, Seat seat, User user);

    List<Seat> getAllLockedSeats(Show show);

    Long getExpiryDuration();

    boolean validateLock(Show show, List<Seat> seats, User user);


}
