package com.example.travelbuddyapps.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Vibrator;
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

    protected EditText etusername, etpassword;
    private Button btnlogin;
    boolean flag = false;
    private SensorManager sensorManager;
    NotificationManagerCompat notificationManagerCompat;
    Vibrator vibrate;

    Broadcast broadcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        broadcast=new Broadcast();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        Channel channel = new Channel (this);
        channel.createChannel();
        vibrate=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        displayNotification();


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
                            vibrate.vibrate(1000);
                            Toast.makeText(login.this,"Login Failed",Toast.LENGTH_SHORT).show();
                        } else{
                            Url.token = "Bearer " + response.body().getToken();
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

    private void displayNotification() {

        Notification notification = new NotificationCompat.Builder(this, Channel.channel_2)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Connected")
                .setContentText("Internet is working")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);


    }
    private void proximity(){
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        SensorEventListener proxilistener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.values[0]<=4 && flag==false){
//                    login();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(proxilistener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcast, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
       unregisterReceiver(broadcast);
    }
}


