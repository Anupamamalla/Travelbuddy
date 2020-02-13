package com.example.travelbuddyapps.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.travelbuddyapps.Adapater.CardAdapter;
import com.example.travelbuddyapps.R;

import static com.example.travelbuddyapps.Activity.Dashboard.lstpackage;

public class CardFragment extends Fragment {

   RecyclerView rv;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_card, container, false);

        rv = v.findViewById(R.id.cardrec);
        CardAdapter sa = new CardAdapter(getContext(),lstpackage);
        rv.setAdapter(sa);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        return v;


    }

    }

