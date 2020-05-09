package com.abhisheknarwal.covid_19trackerindia;

import com.google.gson.annotations.SerializedName;

public class DistrictDataItem{

	@SerializedName("recovered")
	private int recovered;

	@SerializedName("notes")
	private String notes;

	@SerializedName("deceased")
	private int deceased;

	@SerializedName("district")
	private String district;

	@SerializedName("delta")
	private Delta delta;

	@SerializedName("active")
	private int active;

	@SerializedName("confirmed")
	private int confirmed;

	public int getRecovered(){
		return recovered;
	}

	public String getNotes(){
		return notes;
	}

	public int getDeceased(){
		return deceased;
	}

	public String getDistrict(){
		return district;
	}

	public Delta getDelta(){
		return delta;
	}

	public int getActive(){
		return active;
	}

	public int getConfirmed(){
		return confirmed;
	}
}