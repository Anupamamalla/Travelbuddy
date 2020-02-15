package com.example.travelbuddyapps.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelbuddyapps.API.UserApi;
import com.example.travelbuddyapps.Activity.Dashboard;
import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.R;
import com.example.travelbuddyapps.URL.Url;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AccountFragment extends Fragment {
    TextView txtName;
    TextView txtEmail;
    TextView txtCountry;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_account, container, false);
        txtName=view.findViewById(R.id.txtName);
        txtEmail=view.findViewById(R.id.txtEmail);
        txtCountry=view.findViewById(R.id.txtCountry);
        loadUser();
        return view;
    }

    private void loadUser() {
        UserApi userAPI= Url.getInstance().create(UserApi.class);
        Call<User> userModelCall = userAPI.retrieveUserdetail(Url.token);

        userModelCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(),"Code"+response.code(),Toast.LENGTH_LONG).show();
                    return;


                }else {
                    txtName.setText(response.body().getUsername());
                    txtEmail.setText(response.body().getEmail());
                    txtCountry.setText(response.body().getCountry());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(),"Code"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });




            }





}
