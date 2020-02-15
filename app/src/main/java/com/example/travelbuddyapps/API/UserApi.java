package com.example.travelbuddyapps.API;

import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.Severresponse.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserApi {
    @POST("users/register")
    Call<SignupResponse> signup(@Body User user);

    @POST("users/signin")
    @FormUrlEncoded
    Call<SignupResponse> signin (
            @Field("username") String user,
            @Field("password") String password
    );

    @GET("users/myProfile")
    Call<User> retrieveUserdetail(@Header("Authorization")String token);
    @PUT("users/myProfile")
    Call <User> updateUser(@Header("Authorization")String token, @Body User user);
}
