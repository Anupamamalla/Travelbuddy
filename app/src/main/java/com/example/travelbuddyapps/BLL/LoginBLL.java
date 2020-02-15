package com.example.travelbuddyapps.BLL;

import com.example.travelbuddyapps.API.UserApi;
import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.Severresponse.SignupResponse;
import com.example.travelbuddyapps.URL.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {
    private boolean isSuccess;

    public boolean signin(String username, String password) {

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<SignupResponse> usersCall = usersAPI.signin(username, password);

        try {
            Response<SignupResponse> loginResponse = usersCall.execute();
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