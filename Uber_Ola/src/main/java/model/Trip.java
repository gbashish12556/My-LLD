package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Trip {

    private Integer tripId;
    private Driver driver;
    private Rider rider;
    private Location startLocation;
    private Location endLocations;
    private Integer fare;
    private Boolean isRunning;


    public Trip(Driver driver, Rider rider, Location startLocation, Location endLocations, Integer fare, Boolean isRunning) {
        this.driver = driver;
        this.rider = rider;
        this.startLocation = startLocation;
        this.endLocations = endLocations;
        this.fare = fare;
        this.isRunning = isRunning;
    }
}
