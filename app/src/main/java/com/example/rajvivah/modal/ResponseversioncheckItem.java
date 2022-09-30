package com.example.rajvivah.modal;

import com.google.gson.annotations.SerializedName;

public class ResponseversioncheckItem{

	@SerializedName("registeruser_id")
	private Object registeruserId;

	@SerializedName("appversionlanuchdate")
	private String appversionlanuchdate;

	@SerializedName("appversionondevice")
	private String appversionondevice;

	@SerializedName("isactiveversion")
	private boolean isactiveversion;

	@SerializedName("appversion")
	private Object appversion;

	@SerializedName("lastupdate")
	private String lastupdate;

	public Object getRegisteruserId(){
		return registeruserId;
	}

	public String getAppversionlanuchdate(){
		return appversionlanuchdate;
	}

	public String getAppversionondevice(){
		return appversionondevice;
	}

	public boolean isIsactiveversion(){
		return isactiveversion;
	}

	public Object getAppversion(){
		return appversion;
	}

	public String getLastupdate(){
		return lastupdate;
	}
}