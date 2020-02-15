package com.example.travelbuddyapps.BLL;

import com.example.travelbuddyapps.API.UserApi;
import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.Severresponse.SignupResponse;
import com.example.travelbuddyapps.URL.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class RegistrationBLL {
    private boolean isSuccess;

    public boolean signup(String email, String country, String username, String password) {

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<SignupResponse> responseCall = usersAPI.signup(new User(email, country, username, password));

        try {
            Response<SignupResponse> loginResponse = (responseCall).execute();
            if (loginResponse.isSuccessful()){

                Url.token += loginResponse.body().getToken();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}