package com.abhisheknarwal.covid_19trackerindia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhisheknarwal.covid_19trackerindia.DeltaSpannable;
import com.abhisheknarwal.covid_19trackerindia.R;
import com.abhisheknarwal.covid_19trackerindia.model.StatewiseItem;
import com.abhisheknarwal.covid_19trackerindia.onItemClickListener;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {

    private List<StatewiseItem> states;
    private final LayoutInflater layoutInflater;
    private onItemClickListener onItemClickListener;

    public StateAdapter(List<StatewiseItem> states, Context mContext) {
        this.states = states;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.state_item,parent, false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {
        StatewiseItem state = states.get(position);
        if(Integer.parseInt(state.getDeltaconfirmed()) > 0){
            DeltaSpannable spannableString = new DeltaSpannable(state.getConfirmed() + "\n ↑"
                    + state.getDeltaconfirmed(),
                    "#D32F2F",
                    state.getConfirmed().length());
            holder.tvConfirmed.setText(spannableString);
        }else{
            holder.tvConfirmed.setText(state.getConfirmed());
        }
        if(Integer.parseInt(state.getDeltadeaths()) > 0){
            DeltaSpannable spannableString = new DeltaSpannable(state.getDeaths() + "\n ↑"
                    + state.getDeltadeaths(),
                    "#FBC02D",
                    state.getDeaths().length());
            holder.tvDeceased.setText(spannableString);
        }else{
            holder.tvDeceased.setText(state.getDeaths());
        }
        if(Integer.parseInt(state.getDeltarecovered()) > 0){
            DeltaSpannable spannableString = new DeltaSpannable(state.getRecovered() + "\n ↑"
                    + state.getDeltarecovered(),
                    "#388E3C",
                    state.getRecovered().length());
            holder.tvRecovered.setText(spannableString);
        }else{
            holder.tvRecovered.setText(state.getRecovered());
        }
        holder.tvState.setText(state.getState());
        holder.tvActive.setText(state.getActive());
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class StateViewHolder extends RecyclerView.ViewHolder{

        TextView tvState, tvConfirmed, tvActive, tvRecovered, tvDeceased;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            tvActive = itemView.findViewById(R.id.tvActive);
            tvConfirmed = itemView.findViewById(R.id.tvConfirmed);
            tvRecovered = itemView.findViewById(R.id.tvRecovered);
            tvDeceased = itemView.findViewById(R.id.tvDeceased);
            tvState = itemView.findViewById(R.id.tvState);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
