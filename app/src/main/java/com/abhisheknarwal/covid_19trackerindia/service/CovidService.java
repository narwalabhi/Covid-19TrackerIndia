package com.abhisheknarwal.covid_19trackerindia.service;

import com.abhisheknarwal.covid_19trackerindia.DistState;
import com.abhisheknarwal.covid_19trackerindia.model.ResponseState;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidService {

    @GET("data.json")
    Call<ResponseState> getResponse();

    @GET("state_district_wise.json")
    Call<List<DistState>> getStatesWithDistricts();

}
