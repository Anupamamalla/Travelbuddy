package com.example.travelbuddyapps.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.travelbuddyapps.API.PackageAPI;
import com.example.travelbuddyapps.Model.Package;
import com.example.travelbuddyapps.R;
import com.example.travelbuddyapps.URL.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.PUT;

public class ViewPackage extends AppCompatActivity {
TextView Packagename;
TextView Price;
TextView Trans;
TextView Acco;

RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpackage);

        Packagename = findViewById(R.id.Packagename);
        Price = findViewById(R.id.Price);
        Trans = findViewById(R.id.Trans);
        Acco = findViewById(R.id.Acco);


        getpackage();
    }

    private void getpackage() {

        PackageAPI packageAPI = Url.getInstance().create(PackageAPI.class);
        Call<Package> packageCall = packageAPI.getpackage(Url.token);

    }
}
