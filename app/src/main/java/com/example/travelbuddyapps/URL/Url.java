package com.example.travelbuddyapps.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    //for emulator

   public static final String base_url = "http://10.0.2.2:3001/";

    //for testing

//    public static final String base_url = "http://localhost:3001/";
    public static String token ="Bearer ";
    public static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
