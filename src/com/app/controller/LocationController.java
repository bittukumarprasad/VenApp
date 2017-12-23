package com.app.controller;

public class LocationController {

	private String locName;

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getLocName() {
		return locName;
	}

	public String toString() {
		return "LocationController [locName=" + locName + "]";
	}

	public LocationController(String locName) {
		super();
		this.locName = locName;
	}

	public LocationController() {
		super();
	}

}
