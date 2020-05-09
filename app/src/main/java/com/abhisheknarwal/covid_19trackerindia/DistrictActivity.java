package com.abhisheknarwal.covid_19trackerindia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.abhisheknarwal.covid_19trackerindia.adapter.DistrictAdapter;
import com.abhisheknarwal.covid_19trackerindia.service.Client;
import com.abhisheknarwal.covid_19trackerindia.service.CovidService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DistrictActivity extends OptionsMenuActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout slDistricts;
    private DistrictAdapter districtAdapter;
    private List<DistState> distStates;
    private List<DistrictDataItem> districts = new ArrayList<>();
    private String stateCode;
    private String TAG = "DistrictActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.rvDistricts);
        slDistricts = findViewById(R.id.slDistricts);
        slDistricts.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                geData();
            }
        });
        Intent intent = getIntent();
        stateCode = intent.getStringExtra("code");
        Log.d(TAG, "onCreate: ");
        geData();
    }

    private void geData() {
        CovidService service = new Client().getCovidService2();
        Call<List<DistState>> call = service.getStatesWithDistricts();
        call.enqueue(new Callback<List<DistState>>() {
            @Override
            public void onResponse(Call<List<DistState>> call, Response<List<DistState>> response) {
                distStates = response.body();
                for(int i = 0; i < distStates.size(); i++){
                    DistState state = distStates.get(i);
//                    Log.d(TAG, "onResponse: " + state.getStatecode() + " " + stateCode);
                    if(state.getStatecode().equals(stateCode)){
                        districts = state.getDistrictData();
                        Log.d(TAG, "onResponse: " + districts.size());
                        break;
                    }
                }
                setUpList();
            }

            @Override
            public void onFailure(Call<List<DistState>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void setUpList() {
        Log.d(TAG, "setUpList: ");
        districtAdapter = new DistrictAdapter(districts, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(districtAdapter);
        slDistricts.setRefreshing(false);
    }
}
