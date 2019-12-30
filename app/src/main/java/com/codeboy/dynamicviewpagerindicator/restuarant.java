package com.codeboy.dynamicviewpagerindicator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class restuarant extends Fragment {

    private restaurantInfo resto;

    public void setRestaurant(restaurantInfo restaurant) {
        this.resto = restaurant;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_restaurant,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView restuarantName = view.findViewById(R.id.resto_name);
        restuarantName.setText(resto.getRestaurantName());
        TextView restaurantDescription = view.findViewById(R.id.resto_description);
        restaurantDescription.setText(resto.getDescription());


        resto.setDishes(getAllDishes());
        RecyclerView dishesList = view.findViewById(R.id.dish_recycler);
        dishesList.hasFixedSize();
        dishesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        dishAdapter.callback callback = new dishAdapter.callback() {
            @Override
            public void onDishClicked() {
                //add selected dish to user menu
            }
        };

        dishAdapter allDishes = new dishAdapter(getActivity(),resto.getDishes(),callback);
        dishesList.setAdapter(allDishes);
    }


    private ArrayList<dish> getAllDishes(){

        //get dishes first
        ArrayList<dish> dishes = new ArrayList<>();
        String[] dishNames = this.getResources().getStringArray(R.array.dishes);
        String[] dishPics = this.getResources().getStringArray(R.array.dish_icons);
        String[] dishDescription = this.getResources().getStringArray(R.array.dish_descriptions);

        for(int i = 0;i < dishNames.length;i++){
            String dish_name = dishNames[i];
            String dish_description = dishDescription[i];
            String dish_icon = dishPics[i];
            dish dish = new dish(dish_name,dish_description,dish_icon);
            dishes.add(dish);
        }
        return dishes;
    }


}
