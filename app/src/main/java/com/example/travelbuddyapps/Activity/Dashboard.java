package com.example.travelbuddyapps.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.travelbuddyapps.Fragment.Search;
import com.example.travelbuddyapps.Model.Package;
import com.example.travelbuddyapps.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import static com.example.travelbuddyapps.URL.Url.token;

public class Dashboard extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView nv;
    private Toolbar toolbar;
  //Button logout;


    public static List<Package> lstpackage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().hide();
        drawer = findViewById(R.id.drawer);
        NavigationView nv = findViewById(R.id.nav_view);
        //logout = findViewById(R.id.btnlogout);

        //nv.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();




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
                    new Search()).commit();
            nv.setCheckedItem(R.id.home);
        }

       nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId()){
                   case R.id.home:
                       getSupportFragmentManager().beginTransaction().replace(R.id.container,
                               new Search()).commit();
                       break;

                   case R.id.logout:
                       logout();
                       Intent it = new Intent (Dashboard.this,login.class);
                       startActivity(it);

               }
               drawer.closeDrawer(GravityCompat.START);
               return true;
           }

       });

    }

    private void logout() {
        if(token != "Bearer"){
            token ="Bearer";
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
}

