package com.example.travelbuddyapps;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.HashMap;


import android.os.Bundle;

public class ImageSlider extends AppCompatActivity {
    ImageSlider sliderLayout;
    HashMap<String,String> Hash_file_maps ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);

        Hash_file_maps = new HashMap<String, String>();
        sliderLayout = (ImageSlider)findViewById(R.id.slider);
        Hash_file_maps.put("Slider1", "drawable/logo.png");
        Hash_file_maps.put("Slider2", "drawable/logo.png");
        Hash_file_maps.put("Slider3", "drawable/logo.png.png");
        Hash_file_maps.put("Slider4", "drawable/logo.png.png");
        for(String name : Hash_file_maps.keySet()){


    }

}
