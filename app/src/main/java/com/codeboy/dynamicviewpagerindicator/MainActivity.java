package com.codeboy.dynamicviewpagerindicator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView indicator;
    private ViewPager restaurantHolder;
    private ArrayList<restaurantInfo> restauranList;
    ImageView background;
    RelativeLayout blur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }

    private void initializeComponents(){
        indicator = findViewById(R.id.indicatorList);
        indicator.hasFixedSize();
        indicator.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        background = findViewById(R.id.background);
        blur = findViewById(R.id.blur);
        design();

        restaurantHolder = findViewById(R.id.restaurants);
        restaurantHolder.setOffscreenPageLimit(3);
        restaurantHolder.setPageTransformer(true,new ZoomOutPageTransformer());
        loadData();
    }

    private void loadData(){
        getAllRestaurants();
        indicatorAdapter.callback indicatorCallback = new indicatorAdapter.callback() {
            @Override
            public void onTitleClicked(int position) {
                restaurantHolder.setCurrentItem(position);
            }
        };
        final indicatorAdapter indicatorAdapter = new indicatorAdapter(this,restauranList,indicatorCallback);
        indicator.setAdapter(indicatorAdapter);

        MainActivity.restaurantAdapter restaurantAdapter = new restaurantAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        restaurantHolder.setAdapter(restaurantAdapter);

        ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicatorAdapter.setSelectedIndex(position);
                indicatorAdapter.notifyDataSetChanged();
                indicator.scrollToPosition(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        restaurantHolder.addOnPageChangeListener(pageListener);
    }


    private void getAllRestaurants() {
        //get restaurants
        restauranList = new ArrayList<>();
        String[] iconarray = this.getResources().getStringArray(R.array.restaurant_icons);
        String[] namearray = this.getResources().getStringArray(R.array.restaurant_names);
        String[] discriptionarray = this.getResources().getStringArray(R.array.restaurant_descriptions);

        for(int i = 0;i < namearray.length;i++){
            String name = namearray[i];
            String description = discriptionarray[i];
            String logo = iconarray[i];
            restaurantInfo restaurant = new restaurantInfo(name,description,logo);
            restauranList.add(restaurant);
        }
    }

    private void design() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = calculateInSampleSize(options, 200, 200);
        options.inJustDecodeBounds = false;
        Bitmap Background = BitmapFactory.decodeResource(getResources(),R.drawable.food_background_1,options);

        try{
            Palette.from(Background).generate(new Palette.PaletteAsyncListener() {
                public void onGenerated(Palette p) {
                    // Use generated instance

                    int color = 0x000000;
                    int vibrant = p.getVibrantColor(color);
                    blur.setBackgroundColor(Color.argb(180,Color.red(vibrant),Color.green(vibrant),Color.blue(vibrant)));
                }
            });
        }catch(Exception e){
            e.printStackTrace();// bad bitmap
            e.getMessage();
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }


    public class restaurantAdapter extends FragmentPagerAdapter{

        restaurantAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            restuarant resto = new restuarant();
            resto.setRestaurant(restauranList.get(position));
            return resto;
        }

        @Override
        public int getCount() {
            return restauranList.size();
        }
    }


}
