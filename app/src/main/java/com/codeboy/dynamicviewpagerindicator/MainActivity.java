package com.codeboy.dynamicviewpagerindicator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private RecyclerView indicator;
    private ViewPager restaurantHolder;
    private restaurantAdapter restaurantAdapter;
    private ViewPager.OnPageChangeListener pageListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initializeComponents(){
        indicator = findViewById(R.id.indicatorList);
        indicator.hasFixedSize();
        indicator.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        restaurantHolder = findViewById(R.id.restaurants);
        restaurantHolder.setOffscreenPageLimit(3);
        restaurantAdapter = new restaurantAdapter(getSupportFragmentManager());
        restaurantHolder.setAdapter(restaurantAdapter);



    }

    private void initializeListeners(){

        pageListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };



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
