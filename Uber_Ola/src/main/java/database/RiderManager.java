package database;

import model.Driver;
import model.Location;
import model.Rider;

import java.util.HashMap;

public class RiderManager {

    private HashMap<Integer, Rider> ridersList = new HashMap<>();


    void registerDriver(Rider rider){
        ridersList.put(rider.getId(), rider);
    }
}
