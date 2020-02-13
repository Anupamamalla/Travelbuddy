package com.example.travelbuddyapps.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelbuddyapps.API.UserApi;
import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.R;
import com.example.travelbuddyapps.Severresponse.SignupResponse;
import com.example.travelbuddyapps.URL.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    private EditText etusername, etpassword;
    private Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etusername = findViewById(R.id.etUser);
        etpassword = findViewById(R.id.etPass);

        getSupportActionBar().hide();

        TextView signUp_text = findViewById(R.id.signUp_text);
        btnlogin = findViewById(R.id.login);
        signUp_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, Registration.class));

            }
        });



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }



            public void login(){
                UserApi userApi =  Url.getInstance().create(UserApi.class);
                Call<SignupResponse> signupcall = userApi.signin(
                        etusername.getText().toString(),
                        etpassword.getText().toString()
                );

                signupcall.enqueue(new Callback<SignupResponse>() {
                    @Override
                    public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(login.this,"Error",Toast.LENGTH_SHORT).show();
                        } else{
                            Url.token+=response.body().getToken();
                            Toast.makeText(login.this,"token:"+response.body().getToken(),Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(getApplicationContext(), Dashboard.class);
                            startActivity(login);

                        }
                    }


                    @Override
                    public void onFailure(Call<SignupResponse> call, Throwable t) {

                    }
                });

            }
        });



    }
}

