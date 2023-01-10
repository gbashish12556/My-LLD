package org.example.model;

import org.example.enums.CuisineType;
import org.example.enums.MealType;

public class FoodItem {

    Integer id;
    double price;
    String name;
    MealType mealType;
    CuisineType cuisineType;

    public Integer getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public MealType getMealType() {
        return mealType;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }


}
