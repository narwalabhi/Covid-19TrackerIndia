package com.abhisheknarwal.covid_19trackerindia.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();

    private Gson gson2 = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    private Retrofit retrofitInstance = new Retrofit.Builder()
            .baseUrl("https://api.covid19india.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


    private Retrofit retrofitInstance2 = new Retrofit.Builder()
            .baseUrl("https://api.covid19india.org/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private CovidService covidService = retrofitInstance.create(CovidService.class);

    private CovidService covidService2 = retrofitInstance2.create(CovidService.class);

    public CovidService getCovidService(){
        return this.covidService;
    }

    public CovidService getCovidService2() {
        return covidService2;
    }
}
