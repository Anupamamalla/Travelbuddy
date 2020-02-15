package com.example.weartravelbuddy.API;

import com.example.weartravelbuddy.ServerResponse.SigninResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {
    @POST("users/signin")
    @FormUrlEncoded
    Call<SigninResponse> signin (
            @Field("username") String user,
            @Field("password") String password
    );


}
