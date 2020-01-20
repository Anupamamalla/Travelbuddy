package com.example.travelbuddyapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    private Button Signup;
    private EditText Username, Email, Password;
    private Spinner Country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Signup = findViewById(R.id.btnSignup);
        Username = findViewById(R.id.etUser);
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPass);
        Country = findViewById(R.id.etCountry);



        TextView signIn_text = findViewById(R.id.signIn_text);
        signIn_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, login.class));
                finish();
            }
        });
    }
}
