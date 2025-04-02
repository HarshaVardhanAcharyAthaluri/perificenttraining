package com.training.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class Adress {

	private String state;
	private String city;
	private String zip;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Adress [state=" + state + ", city=" + city + ", zip=" + zip + "]";
	}
	
	
}
