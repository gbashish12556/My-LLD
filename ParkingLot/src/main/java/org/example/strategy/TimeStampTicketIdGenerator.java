package org.example.strategy;

public class TimeStampTicketIdGenerator implements TicketIdGenerator{

    public TimeStampTicketIdGenerator(){

    }

    @Override
    public long getTicketNo() {

        return System.currentTimeMillis();

    }

}
