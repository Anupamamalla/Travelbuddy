package com.example.travelbuddyapps.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelbuddyapps.Model.Package;
import com.example.travelbuddyapps.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewholder> {

    Context mContext;
    List<Package> lstpack;

    public SearchAdapter(Context mContext, List<Package> lstpack){

        this.mContext=mContext;
        this.lstpack = lstpack;

    }


    @NonNull
    @Override
    public SearchViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.activity_cardview,parent,false);

            return new SearchViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewholder holder, int position) {

        Package pac = lstpack.get(position);
        holder.img.setImageResource(pac.getImage());
        holder.txtname.setText(pac.getTitle());

    }

    @Override
    public int getItemCount() {
        return lstpack.size();
    }


    public  class SearchViewholder extends  RecyclerView.ViewHolder{

       ImageView img;
        TextView txtname;
        public SearchViewholder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            txtname = itemView.findViewById(R.id.txtTitle);
        }
    }



}
