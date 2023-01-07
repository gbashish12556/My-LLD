package model;

import java.security.Permission;

public class Driver extends Rider {

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    private Location currentLocation;
    private Trip currentTrip;

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    private Boolean isAvailable;

}
