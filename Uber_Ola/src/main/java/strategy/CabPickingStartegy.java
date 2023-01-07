package strategy;

import model.Driver;

import java.util.List;

public interface CabPickingStartegy {

    Driver getDriver(List<Driver> driverList);
}
