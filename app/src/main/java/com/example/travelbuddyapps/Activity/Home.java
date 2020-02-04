package com.example.travelbuddyapps.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.travelbuddyapps.R;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {
    Button btnsubmit;
    EditText Start;
    EditText End;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Start=(EditText)findViewById(R.id.startdate);


    }
}
