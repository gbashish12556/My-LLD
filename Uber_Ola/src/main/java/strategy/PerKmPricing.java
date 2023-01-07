package strategy;

import model.Location;

public class PerKmPricing implements PricingStrategy{
    @Override
    public Integer getPrice(Location startPoint, Location endPoint) {

        Double distance = Math.sqrt(Math.pow(endPoint.getxCord() - startPoint.getxCord(),2)
        +Math.pow(endPoint.getyCord() - startPoint.getyCord(),2));
        Math.floor(distance*10);

        return null;
    }
}
