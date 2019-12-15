package com.codeboy.dynamicviewpagerindicator;

public class dish {

    private String dishName;
    private String dishDescription;
    private String dishIcon;

    public dish (){

    }

    public dish(String dishName, String dishDescription, String dishIcon) {
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.dishIcon = dishIcon;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getDishIcon() {
        return dishIcon;
    }

    public void setDishIcon(String dishIcon) {
        this.dishIcon = dishIcon;
    }


}
