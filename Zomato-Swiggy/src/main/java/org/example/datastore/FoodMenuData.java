package org.example.datastore;

import org.example.enums.CuisineType;
import org.example.enums.MealType;
import org.example.exceptions.ExceptionType;
import org.example.exceptions.RestaurantException;
import org.example.model.FoodItem;
import org.example.model.FoodMenu;

import java.util.HashMap;
import java.util.List;

public class FoodMenuData {

    HashMap<Integer, Integer> restaurantToFoodMeny;
    HashMap<Integer, FoodMenu> menuMapping;

    HashMap<Integer, FoodItem> foodItemMapping;

    public HashMap<Integer, Integer> getRestaurantToFoodMeny() {
        return restaurantToFoodMeny;
    }

    public HashMap<Integer, FoodMenu> getMenuMapping() {
        return menuMapping;
    }

    public HashMap<Integer, FoodItem> getFoodItemMapping() {
        return foodItemMapping;
    }

    public FoodMenu getFoodMenuOfRestaurant(Integer restaurantId) throws RestaurantException{

        if(!restaurantToFoodMeny.containsKey(restaurantId)){
            throw  new RestaurantException(ExceptionType.RESTAURANT_NOT_FOUND, "Not Found");
        }

        return menuMapping.get(restaurantToFoodMeny.get(restaurantId));
    }

    public void addFoodMenu(FoodMenu foodMenu, Integer restaurantId){

        

    }


}
