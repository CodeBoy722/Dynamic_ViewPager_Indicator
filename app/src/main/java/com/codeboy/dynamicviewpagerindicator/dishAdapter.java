package com.codeboy.dynamicviewpagerindicator;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class dishAdapter extends RecyclerView.Adapter<dishAdapter.distViewHolder>{


    @NonNull
    @Override
    public distViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull distViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class distViewHolder extends RecyclerView.ViewHolder {
        //instanciate views

        public distViewHolder(@NonNull View itemView) {
            super(itemView);
            //init views
        }
    }

}
