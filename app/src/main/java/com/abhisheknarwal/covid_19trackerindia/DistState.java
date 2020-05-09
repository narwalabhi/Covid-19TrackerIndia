package com.abhisheknarwal.covid_19trackerindia;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DistState{

	@SerializedName("districtData")
	private List<DistrictDataItem> districtData;

	@SerializedName("state")
	private String state;

	@SerializedName("statecode")
	private String statecode;

	public List<DistrictDataItem> getDistrictData(){
		return districtData;
	}

	public String getState(){
		return state;
	}

	public String getStatecode(){
		return statecode;
	}
}