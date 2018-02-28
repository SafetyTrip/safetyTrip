package com.dto;

public class OpenDataDTO {
	private String content;
    private String countryEnName;
    private String countryName;
    private String id;
    private String title;
    private String wrtDt;
	
    public OpenDataDTO() {
	}
	
    public OpenDataDTO(String content, String contryEnName, String countryName, String id, String title, String wrtDt) {
		this.content = content;
		this.countryEnName = contryEnName;
		this.countryName = countryName;
		this.id = id;
		this.title = title;
		this.wrtDt = wrtDt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCountryEnName() {
		return countryEnName;
	}

	public void setCountryEnName(String contryEnName) {
		this.countryEnName = contryEnName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWrtDt() {
		return wrtDt;
	}

	public void setWrtDt(String wrtDt) {
		this.wrtDt = wrtDt;
	}    
}
