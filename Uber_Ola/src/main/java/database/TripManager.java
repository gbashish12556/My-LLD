package database;

import model.Driver;
import model.Location;
import model.Rider;
import model.Trip;
import strategy.CabPickingStartegy;
import strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TripManager {


    HashMap<Integer, ArrayList<Trip>> trips = new HashMap<>();

    private DriverManager driverManager;
    private PricingStrategy pricingStrategy;
    private CabPickingStartegy cabPickingStartegy;


    public void createTrip(Rider rider, Location startPoint, Location endPoint){

        Driver driver = cabPickingStartegy.getDriver(driverManager.getAvailableDrivers());
        Integer fare = pricingStrategy.getPrice(startPoint,endPoint);

        Trip trip = new Trip(driver, rider, startPoint, endPoint, fare, true);

    };

    public void addTrip(Integer driverId, Trip trip){

        if(!trips.containsKey(driverId)){
            trips.put(driverId, new ArrayList<>());
        }

        trips.get(driverId).add(trip);


    }

    public void endTrip(Integer driverId, Integer tripId){

    }

    List<Trip> getDriverTripHistory(Integer driverid){

        return trips.get(driverid);

    }
}
