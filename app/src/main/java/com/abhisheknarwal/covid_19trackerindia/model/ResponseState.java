package com.abhisheknarwal.covid_19trackerindia.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseState {

	@SerializedName("cases_time_series")
	private List<CasesTimeSeriesItem> casesTimeSeries;

	@SerializedName("tested")
	private List<TestedItem> tested;

	@SerializedName("statewise")
	private List<StatewiseItem> statewise;

	public List<CasesTimeSeriesItem> getCasesTimeSeries(){
		return casesTimeSeries;
	}

	public List<TestedItem> getTested(){
		return tested;
	}

	public List<StatewiseItem> getStatewise(){
		return statewise;
	}
}