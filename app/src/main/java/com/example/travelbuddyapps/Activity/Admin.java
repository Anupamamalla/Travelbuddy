package com.example.travelbuddyapps.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.travelbuddyapps.API.PackageAPI;
import com.example.travelbuddyapps.Model.InsertPackage;
import com.example.travelbuddyapps.R;
import com.example.travelbuddyapps.URL.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Admin extends AppCompatActivity {

    private Button btnAdd;
    private EditText etPackage, etPrice, ettrans, etacco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        btnAdd = findViewById(R.id.btnAdd);
        etPackage = findViewById(R.id.etpackage);
        etPrice = findViewById(R.id.etprice);
        ettrans = findViewById(R.id.ettrans);
        etacco = findViewById(R.id.etacco);



        getSupportActionBar().hide();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addpackage();
            }
        });
    }

    private void addpackage()
    {
        String packagename = etPackage.getText().toString();
        String price = etPrice.getText().toString();
        String transportation = ettrans.getText().toString();
        String accomodation = etacco.getText().toString();



        InsertPackage insertPackage = new InsertPackage(packagename, price, transportation, accomodation );

       PackageAPI packageAPI = Url.getInstance().create(PackageAPI.class);
               Call<Void>call=packageAPI.addpackage(Url.token,insertPackage);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(Admin.this, "code:"+response.body(),Toast.LENGTH_SHORT).show();
                    return;

                }
                Toast.makeText(Admin.this,"Your package is added",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                {
                    Toast.makeText(Admin.this,"Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
