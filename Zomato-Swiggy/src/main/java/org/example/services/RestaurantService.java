package org.example.services;

import org.example.datastore.RestaurantData;
import org.example.enums.CityName;
import org.example.exceptions.ExceptionType;
import org.example.exceptions.RestaurantException;
import org.example.model.FoodItem;
import org.example.model.FoodMenu;
import org.example.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantService {

    private RestaurantData restaurantData;

    public void registerRestaurant(Restaurant restaurant) throws RestaurantException{

        restaurantData.registerRestaurant(restaurant);

    }


    public ArrayList<Restaurant> getRestaurantFromCityName(CityName cityName) throws RestaurantException {

        return restaurantData.getRestaurantFromCityName(cityName);

    }



}
