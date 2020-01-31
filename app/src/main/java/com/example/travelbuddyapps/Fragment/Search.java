package com.example.travelbuddyapps.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelbuddyapps.Adapater.SearchAdapter;
import com.example.travelbuddyapps.R;

import static com.example.travelbuddyapps.Activity.Dashboard.lstpackage;

public class Search extends Fragment {

   RecyclerView rv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        rv = v.findViewById(R.id.searchrec);
        SearchAdapter sa = new SearchAdapter(getContext(),lstpackage);
        rv.setAdapter(sa);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        return v;


    }

    }

