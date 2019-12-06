package com.codeboy.dynamicviewpagerindicator;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class indicatorAdapter extends RecyclerView.Adapter<indicatorAdapter.indicatorViewHolder>{


    @NonNull
    @Override
    public indicatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull indicatorViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class indicatorViewHolder extends RecyclerView.ViewHolder {
        //define sub views
        public indicatorViewHolder(@NonNull View itemView) {
            super(itemView);
            //instantiate views
        }
    }

}
