package com.codeboy.dynamicviewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class indicatorAdapter extends RecyclerView.Adapter<indicatorAdapter.indicatorViewHolder>{

    private Context RestaurantContx;
    private ArrayList<restaurantInfo> restgaurants;
    private callback listener;
    private View selectView;
    private int selectedIndex;

    indicatorAdapter(Context restaurantContx, ArrayList<restaurantInfo> restgaurants, callback listener) {
        RestaurantContx = restaurantContx;
        this.restgaurants = restgaurants;
        this.listener = listener;
        selectedIndex = 0;
    }

    @NonNull
    @Override
    public indicatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(RestaurantContx);
        View itemView = inflater.inflate(R.layout.layout_indicator_item,null,false);
        return new indicatorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final indicatorViewHolder holder, final int position) {
        restaurantInfo restaurant = restgaurants.get(position);
        Resources resources = RestaurantContx.getResources();
        final int resourceId = resources.getIdentifier(restaurant.getLogoName(),"drawable",RestaurantContx.getPackageName());
        Glide.with(RestaurantContx)
                .load(resourceId)
                .apply(new RequestOptions().placeholder(R.drawable.food_background_1).fitCenter())
                .into(holder.logo);

        if(selectedIndex == position){
            holder.bottomIndicator.setBackgroundColor(RestaurantContx.getResources().getColor(R.color.white));
            holder.bottomIndicator.setVisibility(View.VISIBLE);
            selectedIndex = position;
            selectView = holder.bottomIndicator;
        }else {
            holder.bottomIndicator.setBackgroundColor(Color.TRANSPARENT);
            holder.bottomIndicator.setVisibility(View.GONE);
        }


        holder.clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.bottomIndicator.setBackgroundColor(RestaurantContx.getResources().getColor(R.color.white));
                holder.bottomIndicator.setVisibility(View.VISIBLE);
                if(selectedIndex != position){
                    selectView.setBackgroundColor(Color.TRANSPARENT);
                    selectView.setVisibility(View.GONE);
                }
                selectView = holder.bottomIndicator;
                selectedIndex = position;
                listener.onTitleClicked(position);
            }
        });
    }

   void setSelectedIndex(int position){
      selectedIndex = position;
   }

    public interface callback{
        void onTitleClicked(int position);
    }

    @Override
    public int getItemCount() {
        return restgaurants.size();
    }

    class indicatorViewHolder extends RecyclerView.ViewHolder {
        //define sub views
        ImageView logo;
        RatingBar ratings;
        View clicker;
        View bottomIndicator;
        indicatorViewHolder(@NonNull View itemView) {
            super(itemView);
            //instantiate views
            logo = itemView.findViewById(R.id.logo);
            ratings = itemView.findViewById(R.id.rating);
            clicker = itemView.findViewById(R.id.clickr);
            bottomIndicator = itemView.findViewById(R.id.bottom_indicator);
        }
    }

}
