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
import com.example.travelbuddyapps.URL.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    private EditText etusername,etpassword;
    private Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        etusername = findViewById(R.id.etUser);
        etpassword = findViewById(R.id.etPass);
        setContentView(R.layout.activity_login);

        TextView signUp_text = findViewById(R.id.signUp_text);

        btnlogin = findViewById(R.id.login);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }

            private void login()
            {
             String username = etusername.getText().toString();
             String password = etpassword.getText().toString();


                User user = new User(username,password);

                UserApi userApi = Url.getInstance().create(UserApi.class);
                final Call<Void>  login = userApi.signin(user);

                login.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(login.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }

                        opendas();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(login.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                    private  void opendas(){
                        Intent i = new Intent(login.this,Dashboard.class);
                        startActivity(i);
                    }
                });


            }
        });
        signUp_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, Registration.class));
                finish();
            }
        });


    }
    public void openDashBoard(){
        Intent openDash = new Intent(this, Dashboard.class);
        startActivity(openDash);
    }
}
