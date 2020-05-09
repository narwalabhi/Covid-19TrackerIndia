package com.abhisheknarwal.covid_19trackerindia.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.abhisheknarwal.covid_19trackerindia.DistrictDataItem;
import com.abhisheknarwal.covid_19trackerindia.R;

import java.util.List;

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.DistViewHolder> {

    List<DistrictDataItem> districts;
    LayoutInflater layoutInflater;

    public DistrictAdapter(List<DistrictDataItem> districts, Context context) {
        this.districts = districts;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.district_item, parent, false);
        return new DistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DistViewHolder holder, int position) {
        DistrictDataItem district = districts.get(position);
        holder.tvConfirmed.setText(String.valueOf(district.getConfirmed()));
        holder.tvDeceased.setText(String.valueOf(district.getDeceased()));
        holder.tvRecovered.setText(String.valueOf(district.getRecovered()));
        holder.tvState.setText(String.valueOf(district.getDistrict()));
        holder.tvActive.setText(String.valueOf(district.getActive()));
    }

    @Override
    public int getItemCount() {
        return districts.size();
    }

    public class DistViewHolder extends RecyclerView.ViewHolder{

        TextView tvState, tvConfirmed, tvActive, tvRecovered, tvDeceased;

        public DistViewHolder(@NonNull View itemView) {
            super(itemView);
            tvActive = itemView.findViewById(R.id.tvDistActive);
            tvConfirmed = itemView.findViewById(R.id.tvDistConfirmed);
            tvRecovered = itemView.findViewById(R.id.tvDistRecovered);
            tvDeceased = itemView.findViewById(R.id.tvDistDeceased);
            tvState = itemView.findViewById(R.id.tvDistrict);
        }
    }
}
