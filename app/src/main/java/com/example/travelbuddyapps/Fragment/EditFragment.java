package com.example.travelbuddyapps.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelbuddyapps.API.UserApi;
import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.R;
import com.example.travelbuddyapps.URL.Url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditFragment extends Fragment {
    EditText editUser;
    EditText editEmail;
    Spinner editCountry;
    Button btnEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_edit, container, false);
        editUser = view.findViewById(R.id.editUser);
        editEmail = view.findViewById(R.id.editEmail);
        editCountry = view.findViewById(R.id.editCountry);
        btnEdit = view.findViewById(R.id.btnProfile);
        loadUser();
        return view;

    }

    private void loadUser() {
        UserApi userAPI = Url.getInstance().create(UserApi.class);
        Call<User> userModelCall = userAPI.retrieveUserdetail(Url.token);

        userModelCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code" + response.code(), Toast.LENGTH_LONG).show();
                    return;


                } else {
                    editUser.setText(response.body().getUsername());
                    editEmail.setText(response.body().getEmail());
                    List<String> countrylist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.country_arrays)));
                    editCountry.setSelection(countrylist.indexOf(response.body().getCountry()));



                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), "Code" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}




