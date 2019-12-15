package com.codeboy.dynamicviewpagerindicator;

import java.util.ArrayList;

public class restaurantInfo {

    private String restaurantName;
    private String description;
    private String logoName;
    private ArrayList<dish> dishes;

    public restaurantInfo(){

    }

    public restaurantInfo(String restaurantName, String description, String logoName, ArrayList<dish> dishes) {
        this.restaurantName = restaurantName;
        this.description = description;
        this.logoName = logoName;
        this.dishes = dishes;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public ArrayList<dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<dish> dishes) {
        this.dishes = dishes;
    }
}
