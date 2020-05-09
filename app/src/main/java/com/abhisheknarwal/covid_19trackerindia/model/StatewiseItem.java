package com.abhisheknarwal.covid_19trackerindia.model;

import com.google.gson.annotations.SerializedName;

public class StatewiseItem{

	@SerializedName("statenotes")
	private String statenotes;

	@SerializedName("recovered")
	private String recovered;

	@SerializedName("deltadeaths")
	private String deltadeaths;

	@SerializedName("deltarecovered")
	private String deltarecovered;

	@SerializedName("active")
	private String active;

	@SerializedName("deltaconfirmed")
	private String deltaconfirmed;

	@SerializedName("state")
	private String state;

	@SerializedName("statecode")
	private String statecode;

	@SerializedName("confirmed")
	private String confirmed;

	@SerializedName("deaths")
	private String deaths;

	@SerializedName("lastupdatedtime")
	private String lastupdatedtime;

	public String getStatenotes(){
		return statenotes;
	}

	public String getRecovered(){
		return recovered;
	}

	public String getDeltadeaths(){
		return deltadeaths;
	}

	public String getDeltarecovered(){
		return deltarecovered;
	}

	public String getActive(){
		return active;
	}

	public String getDeltaconfirmed(){
		return deltaconfirmed;
	}

	public String getState(){
		return state;
	}

	public String getStatecode(){
		return statecode;
	}

	public String getConfirmed(){
		return confirmed;
	}

	public String getDeaths(){
		return deaths;
	}

	public String getLastupdatedtime(){
		return lastupdatedtime;
	}
}