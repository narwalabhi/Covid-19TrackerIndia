package com.abhisheknarwal.covid_19trackerindia;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.abhisheknarwal.covid_19trackerindia.adapter.StateAdapter;
import com.abhisheknarwal.covid_19trackerindia.model.ResponseState;
import com.abhisheknarwal.covid_19trackerindia.model.StatewiseItem;
import com.abhisheknarwal.covid_19trackerindia.service.Client;
import com.abhisheknarwal.covid_19trackerindia.service.CovidService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends OptionsMenuActivity implements onItemClickListener {
    private Toolbar toolbar;
    private String TAG = "MainActivity";
    private SwipeRefreshLayout slMain;
    private StateAdapter stateAdapter;
    private RecyclerView rvStates;
    private List<StatewiseItem> states;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getUpdate();
        rvStates = findViewById(R.id.rvStates);
        slMain = findViewById(R.id.slMain);
        slMain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getUpdate();
                Log.d(TAG, "onRefresh: Done");
            }
        });
    }

    private void getUpdate() {
        CovidService service = new Client().getCovidService();
        Call<ResponseState> call = service.getResponse();
        call.enqueue(new Callback<ResponseState>() {
            @Override
            public void onResponse(Call<ResponseState> call, retrofit2.Response<ResponseState> response) {
                Log.d(TAG, "onResponse: " + response.body().getStatewise().size());
                states = response.body().getStatewise().subList(1,response.body().getStatewise().size());
                Log.d(TAG, "onResponse: " + states.size());
                setRecyclerView(states);
            }

            @Override
            public void onFailure(Call<ResponseState> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView(List<StatewiseItem> states) {
        stateAdapter = new StateAdapter(states,MainActivity.this);
        rvStates.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvStates.setAdapter(stateAdapter);
        stateAdapter.setOnItemClickListener(this);
        slMain.setRefreshing(false);
    }

    @Override
    public void onItemClick(int position) {
        StatewiseItem state =  states.get(position);
        Intent intent = new Intent(this, DistrictActivity.class);
        intent.putExtra("code", state.getStatecode());
        startActivity(intent);
    }

}
