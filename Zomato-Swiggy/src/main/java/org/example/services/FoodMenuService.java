package org.example.services;

import org.example.datastore.FoodMenuData;
import org.example.exceptions.RestaurantException;
import org.example.model.FoodItem;
import org.example.model.FoodMenu;

public class FoodMenuService {

    private FoodMenuData foodMenuData;

    public FoodMenu getFoodMenu(Integer restaurantId) {

        return restaurantData.getFoodMenu(restaurantId);


    }

    public void addFoodItem(Integer restaurantId, FoodItem foodItem) throws RestaurantException {

        restaurantData.addFoodItem(restaurantId, foodItem);

    }

    public void deleteFoodItem(int restaurantId, int foodItemId){

        restaurantData.deleteFoodItem(restaurantId,foodItemId);

    }

    public void updateFoodItem(int restaurantId, Integer foodItemId, FoodItem foodItem){

        restaurantData.updateFoodItem(restaurantId, foodItemId, foodItem);

    }

}
