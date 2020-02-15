package com.example.travelbuddyapps.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.travelbuddyapps.API.UserApi;
import com.example.travelbuddyapps.Model.User;
import com.example.travelbuddyapps.R;
import com.example.travelbuddyapps.URL.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.travelbuddyapps.Activity.Dashboard.globaluser;

public class Edit extends AppCompatActivity {

    private Button btnedit;
    private EditText username, email;
    private Spinner country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnedit = findViewById(R.id.btnProfile);
        username = findViewById(R.id.editUser);
        email = findViewById(R.id.editEmail);
        country = findViewById(R.id.editCountry);

        username.setText(globaluser.getUsername());
        email.setText(globaluser.getEmail());



    }

//        private void editprofile(String username, String country, String email){
//
//       User user= new User (username,email,country);
//         try{
//             UserApi userApi= Url.getInstance().create(UserApi.class);
//             Call<User> userCall=userApi.updateUser(Url.token,user_id);
//            userCall.enqueue(new Callback<User>() {
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
//                    Toast.makeText(Edit.this, "Profile updated.", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//
//                }
//            });
//
//         }catch (IOException e){
//
//         }
//
//
//
//
//        }
}
