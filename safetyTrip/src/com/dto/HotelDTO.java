package com.dto;

public class HotelDTO {
	
	private int hno;
	private int cityno;
	private String hname;
	private int good;
	private String address;
	private String lat;
	private String lng;
	
	public HotelDTO() {}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public int getCityno() {
		return cityno;
	}

	public void setCityno(int cityno) {
		this.cityno = cityno;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "HotelDTO [hno=" + hno + ", cityno=" + cityno + ", hname=" + hname + ", good=" + good + ", address="
				+ address + ", lat=" + lat + ", lng=" + lng + "]";
	}
}
