package com.example.weartravelbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weartravelbuddy.API.UserApi;
import com.example.weartravelbuddy.ServerResponse.SigninResponse;
import com.example.weartravelbuddy.URL.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends WearableActivity {

    private EditText etusername, etpassword;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etusername = findViewById(R.id.etUser);
        etpassword = findViewById(R.id.etPass);
        btnlogin = findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }


        public void login(){
            UserApi userApi =  Url.getInstance().create(UserApi.class);
            Call<SigninResponse> signupcall = userApi.signin(
                    etusername.getText().toString(),
                    etpassword.getText().toString()
            );

            signupcall.enqueue(new Callback<SigninResponse>() {
                @Override
                public void onResponse(Call<SigninResponse> call, Response<SigninResponse> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    } else{
                        Url.token = "Bearer " + response.body().getToken();
                        Toast.makeText(LoginActivity.this,"token:"+response.body().getToken(),Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(login);

                    }
                }


                @Override
                public void onFailure(Call<SigninResponse> call, Throwable t) {

                }
            });

        }
    }











