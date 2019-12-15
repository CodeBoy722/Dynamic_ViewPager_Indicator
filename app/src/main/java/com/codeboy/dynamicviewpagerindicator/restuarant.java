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

public class restuarant extends Fragment {

    private dishAdapter dishes;
    private RecyclerView dishesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_restaurant,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView restuarantName = view.findViewById(R.id.resto_name);
        restuarantName.setText("");
        TextView restaurantDescription = view.findViewById(R.id.resto_description);
        restaurantDescription.setText("");
        dishesList = view.findViewById(R.id.dish_recycler);
        dishesList.hasFixedSize();
        dishesList.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
