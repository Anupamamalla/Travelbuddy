package com.example.travelbuddyapps.API;

import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.Severresponse.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserApi {
    @POST("user/register")
    Call<Void> signup(@Body User user);

    @POST("user/signin")
    Call<SignupResponse> signin (@Body User user);

    @GET("user/myProfile")
    Call<User> retrieveUserdetail(@Header("Authorization")String token);
}
