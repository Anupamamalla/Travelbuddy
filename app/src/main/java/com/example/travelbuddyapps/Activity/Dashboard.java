package com.example.travelbuddyapps.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.travelbuddyapps.API.UserApi;
import com.example.travelbuddyapps.Fragment.AccountFragment;
import com.example.travelbuddyapps.Fragment.CardFragment;
import com.example.travelbuddyapps.Fragment.DealFragment;
import com.example.travelbuddyapps.Fragment.EditFragment;
import com.example.travelbuddyapps.Model.Package;
import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.R;
import com.example.travelbuddyapps.URL.Url;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.travelbuddyapps.URL.Url.token;

public class Dashboard extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView nv;
    private Toolbar toolbar;
    private Button btnviewpac;
    TextView textViewHeaderUsername;

    private NotificationManagerCompat notificationManagerCompat;


    public static User user_id;

    public static List<Package> lstpackage;
    public static User globaluser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().hide();
        drawer = findViewById(R.id.drawer);
        NavigationView nv = findViewById(R.id.nav_view);
        textViewHeaderUsername = nv.getHeaderView(0).findViewById(R.id.headerview_user);

          loaduser();



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

//        btnviewpac = findViewById(R.id.btnViewPac);
//
//        startActivity(new Intent(Dashboard.this, ViewPackage.class));




        lstpackage = new ArrayList<>();
        lstpackage.add(new Package(R.drawable.cardone,"Janakpur"));
        lstpackage.add(new Package(R.drawable.cardtwo,"Tilicho"));
        lstpackage.add(new Package(R.drawable.cardthree,"Mustang"));
        lstpackage.add(new Package(R.drawable.cardfour, "Patan"));
        lstpackage.add(new Package(R.drawable.cardfour, "Patan"));
        lstpackage.add(new Package(R.drawable.cardfour, "Patan"));
        lstpackage.add(new Package(R.drawable.cardfour, "Patan"));
        lstpackage.add(new Package(R.drawable.cardfour, "Patan"));
        lstpackage.add(new Package(R.drawable.cardfour, "Patan"));
        lstpackage.add(new Package(R.drawable.cardfour, "Patan"));
        lstpackage.add(new Package(R.drawable.cardfour, "Patan"));






        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CardFragment()).commit();
            nv.setCheckedItem(R.id.home);
        }

       nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId()){
                   case R.id.home:
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                               new CardFragment()).commit();
                       break;
                   case R.id.deals:
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                               new DealFragment()).commit();
                       break;

                   case R.id.account:
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                               new AccountFragment()).commit();

                       break;

                   case R.id.edit:
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                               new EditFragment()).commit();

                       break;

                   case R.id.logout:
                       logout();
                       Intent intent = new Intent(Dashboard.this,login.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);

                       break;
               }
               drawer.closeDrawer(GravityCompat.START);
               return true;
           }

       });

    }


    private void logout() {
        if(token != "Bearer "){
            Url.token="Bearer ";
        }
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void loaduser() {
        final UserApi userApi = Url.getInstance().create(UserApi.class);
        Call<User> usercall  = userApi.retrieveUserdetail(token);

        usercall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(Dashboard.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                textViewHeaderUsername.setText(response.body().getUsername());
//                       globaluser = response.body();
//                String username =  response.body().getUsername();
//                String email =  response.body().getEmail();
//
//                Toast.makeText(Dashboard.this,"name:"+username,Toast.LENGTH_SHORT).show();
//                TextView tvUsername = (TextView)drawer.findViewById(R.id.tvUsername);
//                TextView tvEmail=(TextView)drawer.findViewById(R.id.tvEmail) ;
//                tvUsername.setText(username);
//                tvEmail.setText(email);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Dashboard.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



}

