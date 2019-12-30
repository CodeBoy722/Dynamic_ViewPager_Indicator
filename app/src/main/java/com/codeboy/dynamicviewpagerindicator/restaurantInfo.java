package com.codeboy.dynamicviewpagerindicator;

import java.util.ArrayList;

public class restaurantInfo {

    private String restaurantName;
    private String description;
    private String logoName;
    private ArrayList<dish> dishes;

    public restaurantInfo(){

    }

    restaurantInfo(String restaurantName, String description, String logoName) {
        this.restaurantName = restaurantName;
        this.description = description;
        this.logoName = logoName;
    }

    String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    ArrayList<dish> getDishes() {
        return dishes;
    }

    void setDishes(ArrayList<dish> dishes) {
        this.dishes = dishes;
    }
}
