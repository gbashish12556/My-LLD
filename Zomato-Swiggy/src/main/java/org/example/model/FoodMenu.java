package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FoodMenu {

    private HashMap<Integer, FoodItem> foodItems;

    public List<FoodItem> getFoodItems() {

        ArrayList<FoodItem> items = new ArrayList<>();
        Iterator it = foodItems.entrySet().iterator();
        while(it.hasNext()){
            items.add((FoodItem) it.next());
        }

        return items;

    }

    public void addFoodItem(FoodItem foodItem){

        foodItems.put(foodItem.id, foodItem);

    }

    public void deleteFoodItem(int itemId){

        foodItems.remove(itemId);

    }

    public void updateFoodItem(FoodItem foodItem){

        foodItems.put(foodItem.getId(), foodItem);

    }
}
