package com.abhisheknarwal.covid_19trackerindia;

import com.google.gson.annotations.SerializedName;

public class Delta{

	@SerializedName("recovered")
	private int recovered;

	@SerializedName("deceased")
	private int deceased;

	@SerializedName("confirmed")
	private int confirmed;

	public int getRecovered(){
		return recovered;
	}

	public int getDeceased(){
		return deceased;
	}

	public int getConfirmed(){
		return confirmed;
	}
}