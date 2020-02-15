package com.example.travelbuddyapps.API;

import com.example.travelbuddyapps.Model.InsertPackage;
import com.example.travelbuddyapps.Model.Package;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PackageAPI {
//    @POST("rem/addevent")
//    Call<Void>addevents(@Header("Authorization")String token,@Body event Event);

    @POST("package/addpackage")
    Call<Void> addpackage(@Header("Authorization") String token, @Body InsertPackage Package);

    @GET("package/viewpackage")
    Call<Package> getpackage(@Header("Authorization") String token);
    }