package controller;

import database.DriverManager;
import database.TripManager;
import model.Driver;
import model.Location;

public class DriverController {

    private TripManager tripManager;
    private DriverManager driverManager;

    DriverController(TripManager tripManager, DriverManager driverManager){

        this.tripManager = tripManager;
        this.driverManager = driverManager;

    }

    void registerDriver(Driver driver){

        driverManager.registerDriver(driver);

    }

    void endTrip(Integer driverId, Integer tripId){

        tripManager.endTrip(driverId,tripId);

    }
    void switchAvailability(Integer driverId){

        driverManager.switchAvailibilty(driverId);

    }

    void updateLocation(Location location, Integer driverId){

        driverManager.updateLocations(location, driverId);
    }

}
