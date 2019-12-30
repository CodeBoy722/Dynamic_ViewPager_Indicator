package com.codeboy.dynamicviewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class dishAdapter extends RecyclerView.Adapter<dishAdapter.distViewHolder>{

    private Context dishContx;
    private ArrayList<dish> dishes;
    private callback listener;

    dishAdapter(Context dishContx, ArrayList<dish> dishes, callback listener) {
        this.dishContx = dishContx;
        this.dishes = dishes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public distViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(dishContx);
        View itemView = inflater.inflate(R.layout.layout_dish_item, null, false);
        return new distViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull distViewHolder holder, int position) {
        dish dish = dishes.get(position);

        holder.dish_name.setText(dish.getDishName());
        holder.dish_description.setText(dish.getDishDescription());

        Resources resources = dishContx.getResources();
        final int resourceId = resources.getIdentifier(dish.getDishIcon(),"drawable",dishContx.getPackageName());
        Glide.with(dishContx)
                .load(resourceId)
                .apply(new RequestOptions().placeholder(R.drawable.food_background_1).fitCenter())
                .into(holder.dishPic);

        holder.order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDishClicked();
            }
        });
    }

    public interface callback{
        void onDishClicked();
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    class distViewHolder extends RecyclerView.ViewHolder {
        //instanciate views
        ImageView dishPic;
        TextView dish_name;
        TextView dish_description;
        ImageButton order;
        distViewHolder(@NonNull View itemView) {
            super(itemView);
            //init views
            dishPic = itemView.findViewById(R.id.dish_image);
            dish_name = itemView.findViewById(R.id.dish_name);
            dish_description = itemView.findViewById(R.id.dish_description);
            order = itemView.findViewById(R.id.add_menu);
        }
    }

}
