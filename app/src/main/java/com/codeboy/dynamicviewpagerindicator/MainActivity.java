package com.codeboy.dynamicviewpagerindicator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    RecyclerView indicator;
    ViewPager restaurantHolder;
    private restaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initializeComponents(){
        indicator = findViewById(R.id.indicatorList);
        restaurantHolder = findViewById(R.id.restaurants);


    }

    public class restaurantAdapter extends FragmentPagerAdapter{

        public restaurantAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }


}
