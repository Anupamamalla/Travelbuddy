package com.example.travelbuddyapps.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Registration extends AppCompatActivity {

    private Button btnSignup;
    private EditText Username, Email, Password;
    private Spinner Country;
    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnSignup = findViewById(R.id.btnSignup);
        Username = findViewById(R.id.etUserReg);
        Email = findViewById(R.id.etEmailReg);
        Password = findViewById(R.id.etPassReg);
        Country = findViewById(R.id.etCountryReg);

        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector= new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                Username.setText("");
                Email.setText("");
                Password.setText("");


            }
        });

        TextView signIn_text = findViewById(R.id.signIn_text);
        btnSignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signup();
            }


        });

    }
    private void signup(){

        String email = Email.getText().toString();
        String country = Country.getSelectedItem().toString();
        String username = Username.getText().toString();
        String password = Password.getText().toString();


        User user = new User(email,country,username,password);

        UserApi userApi= Url.getInstance().create(UserApi.class);
        Call<SignupResponse> call = userApi.signup(user);

        call.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if (!response.isSuccessful()) {

                    Toast.makeText(Registration.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(Registration .this,"Registered",Toast.LENGTH_SHORT).show();
        }





            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Toast.makeText(Registration.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector,mAccelerometer,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        super.onPause();
    }
}
