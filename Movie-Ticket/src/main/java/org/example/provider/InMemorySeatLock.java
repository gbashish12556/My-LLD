package org.example.provider;

import org.example.models.Seat;
import org.example.models.SeatLock;
import org.example.models.Show;
import org.example.models.User;

import java.util.*;

public class InMemorySeatLock implements SeatLockProvider{

    private Long exipryDurations = 10000L;

    HashMap<Show, HashMap<Seat, SeatLock>> seatLocks = new HashMap();


    @Override
    public void lockSeat(Show show, Seat seat, User user) {

        if(!seatLocks.containsKey(show)){
            seatLocks.put(show, new HashMap());
        }

        SeatLock seatLock = new SeatLock(seat, show, new Date(), exipryDurations);

        seatLocks.get(show).put(seat, seatLock);


    }

    @Override
    public boolean isSeatLocked(Show show, Seat seat, User user) {

        if(seatLocks.containsKey(show) && seatLocks.get(show).containsKey(seat) && !seatLocks.get(show).get(seat).isExpired()){
            return true;
        }

        return false;

    }

    @Override
    public void unLockSeat(Show show, Seat seat, User user) {

        seatLocks.get(show).remove(seat);

    }

    @Override
    public List<Seat> getAllLockedSeats(Show show) {

        HashMap<Seat,SeatLock> seatLocked = seatLocks.get(show);
        ArrayList<Seat> seats  = new ArrayList<>(seatLocked.keySet());
        return seats;

    }

    @Override
    public Long getExpiryDuration() {
        return exipryDurations;
    }
}
