package com.dto;

public class CountryDTO {
	private int couno;
	private String cname;
	private String cename;
	
	public CountryDTO() {
	}
	public CountryDTO(int couno, String cname, String cename) {
		this.couno = couno;
		this.cname = cname;
		this.cename = cename;
	}
	
	public int getCouno() {
		return couno;
	}
	public void setCouno(int couno) {
		this.couno = couno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCename() {
		return cename;
	}
	public void setCename(String cename) {
		this.cename = cename;
	}
}
