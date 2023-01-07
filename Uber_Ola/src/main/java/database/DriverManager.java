package database;

import model.Driver;
import model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DriverManager {

    private HashMap<Integer, Driver> driversList = new HashMap<>();

    public void registerDriver(Driver driver){
            driversList.put(driver.getId(), driver);
    }

    public void switchAvailibilty(Integer driverId){

        Driver driver = driversList.get(driverId);
        driver.setAvailable(!driver.getAvailable());


    }

    public void updateLocations(Location location, Integer driverId){

        Driver driver = driversList.get(driverId);
        driver.setCurrentLocation(location);

    }

    public List<Driver> getAvailableDrivers(){

        ArrayList<Driver> availDrivers = new ArrayList<>();
        Iterator iterator = driversList.entrySet().iterator();
        while(iterator.hasNext()){
            Driver driver = ((Driver) iterator.next());
            if(driver.getAvailable() && driver.getCurrentTrip() == null){
                availDrivers.add(driver);
            }
        }
        return  availDrivers;
    }

}
