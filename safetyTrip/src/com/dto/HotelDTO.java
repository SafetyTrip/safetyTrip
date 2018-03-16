package com.dto;

public class HotelDTO {
	
	private int hno;
	private int cityno;
	private String hname;
	private int good;
	
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
}
