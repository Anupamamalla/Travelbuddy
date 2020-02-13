package com.example.travelbuddyapps.API;

import com.example.travelbuddyapps.Model.InsertPackage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PackageAPI {
//    @POST("rem/addevent")
//    Call<Void>addevents(@Header("Authorization")String token,@Body event Event);

    @POST("package/addpackage")
    Call<Void> addpackage(@Header("Authorization") String token, @Body InsertPackage Package);
}