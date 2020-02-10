package com.example.travelbuddyapps.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.R;

import static com.example.travelbuddyapps.Activity.Dashboard.globaluser;

public class Edit extends AppCompatActivity {

    private Button btnedit;
    private EditText username, email, password;
    private Spinner country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnedit = findViewById(R.id.btnProfile);
        username = findViewById(R.id.editUser);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        country = findViewById(R.id.editCountry);

        username.setText(globaluser.getUsername());
        email.setText(globaluser.getEmail());



    }

        private void editprofile(){

        String Username = username.getText().toString();
        String Email = email.getText().toString();

        }
}
