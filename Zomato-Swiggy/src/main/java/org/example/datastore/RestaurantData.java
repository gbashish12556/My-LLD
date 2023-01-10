package org.example.datastore;

import org.example.enums.CityName;
import org.example.exceptions.ExceptionType;
import org.example.exceptions.RestaurantException;
import org.example.model.FoodItem;
import org.example.model.FoodMenu;
import org.example.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantData {

    HashMap<Integer, Restaurant> restaurantList;

    HashMap<CityName, ArrayList<Restaurant>> cityRestaurants;


    public void registerRestaurant(Restaurant restaurant) throws RestaurantException{

        if(restaurantList.get(restaurant.getId()) != null){
            throw new RestaurantException(ExceptionType.RESTAURANT_EXIST, "Already Exist");
        }

        restaurantList.put(restaurant.getId(), restaurant);

        if(cityRestaurants.containsKey(restaurant.getAddress().getCityName())){
            cityRestaurants.put(restaurant.getAddress().getCityName(), new ArrayList<>());
        }

        cityRestaurants.get(restaurant.getAddress().getCityName()).add(restaurant);

    }


    public FoodMenu getFoodMenu(Integer restaurantId) {

        return restaurantList.get(restaurantId).getFoodMenu();


    }

    public void addFoodItem(Integer restaurantId, FoodItem foodItem) throws RestaurantException{

        if(restaurantList.get(restaurantId) == null){

            throw new RestaurantException(ExceptionType.RESTAURANT_NOT_FOUND, "Not found");

        }

        restaurantList.get(restaurantId).getFoodMenu().addFoodItem(foodItem);

    }

    public void deleteFoodItem(int restaurantId, int foodItemId){

        restaurantList.get(restaurantId).getFoodMenu().deleteFoodItem(foodItemId);

    }

    public void updateFoodItem(int restaurantId, Integer foodItemId, FoodItem foodItem){

        restaurantList.get(restaurantId).getFoodMenu().updateFoodItem(foodItem);

    }

    public ArrayList<Restaurant> getRestaurantFromCityName(CityName cityName) throws RestaurantException {

        if(!cityRestaurants.containsKey(cityName)){
            throw new RestaurantException(ExceptionType.RESTAURANT_NOT_FOUND, "Not found");
        }

        return cityRestaurants.get(cityName);

    }

}
