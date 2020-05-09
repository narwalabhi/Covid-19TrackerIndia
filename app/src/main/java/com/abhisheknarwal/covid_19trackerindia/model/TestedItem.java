package com.abhisheknarwal.covid_19trackerindia.model;

import com.google.gson.annotations.SerializedName;

public class TestedItem{

	@SerializedName("testsperconfirmedcase")
	private String testsperconfirmedcase;

	@SerializedName("individualstestedperconfirmedcase")
	private String individualstestedperconfirmedcase;

	@SerializedName("testpositivityrate")
	private String testpositivityrate;

	@SerializedName("testsconductedbyprivatelabs")
	private String testsconductedbyprivatelabs;

	@SerializedName("totalsamplestested")
	private String totalsamplestested;

	@SerializedName("positivecasesfromsamplesreported")
	private String positivecasesfromsamplesreported;

	@SerializedName("samplereportedtoday")
	private String samplereportedtoday;

	@SerializedName("source")
	private String source;

	@SerializedName("updatetimestamp")
	private String updatetimestamp;

	@SerializedName("totalindividualstested")
	private String totalindividualstested;

	@SerializedName("totalpositivecases")
	private String totalpositivecases;

	public String getTestsperconfirmedcase(){
		return testsperconfirmedcase;
	}

	public String getIndividualstestedperconfirmedcase(){
		return individualstestedperconfirmedcase;
	}

	public String getTestpositivityrate(){
		return testpositivityrate;
	}

	public String getTestsconductedbyprivatelabs(){
		return testsconductedbyprivatelabs;
	}

	public String getTotalsamplestested(){
		return totalsamplestested;
	}

	public String getPositivecasesfromsamplesreported(){
		return positivecasesfromsamplesreported;
	}

	public String getSamplereportedtoday(){
		return samplereportedtoday;
	}

	public String getSource(){
		return source;
	}

	public String getUpdatetimestamp(){
		return updatetimestamp;
	}

	public String getTotalindividualstested(){
		return totalindividualstested;
	}

	public String getTotalpositivecases(){
		return totalpositivecases;
	}
}