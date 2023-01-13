package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class SeatLock {

    private Seat seat;
    private Show show;

    private Date lockedAt;

    private Long expiryDuration;


    public boolean isExpired(){

        Date currentTime = new Date();
        if(currentTime.getTime() > lockedAt.getTime()+expiryDuration){

            return true;
        }

        return false;

    }


}
