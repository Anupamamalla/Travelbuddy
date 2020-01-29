package com.example.travelbuddyapps.API;

import com.example.travelbuddyapps.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("user/signup")
    Call<Void> signup (@Body User user);

    @POST("user/signin")
    Call<Void> signin (@Body User user);
}
