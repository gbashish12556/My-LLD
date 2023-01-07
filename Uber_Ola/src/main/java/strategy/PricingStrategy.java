package strategy;

import model.Location;

public interface PricingStrategy {

    Integer getPrice(Location startPoint, Location endPoint);

}
