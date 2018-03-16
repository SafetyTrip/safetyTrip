package com.dto;

public class ReviewDTO {
	private int revno;
	private int uno;
	private int cityno;
	private String title;
	private String content;
	private int viewscount;
	private int good;
	private String createDate;
	
	public ReviewDTO() {}

	public int getRevno() {
		return revno;
	}

	public void setRevno(int revno) {
		this.revno = revno;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public int getCityno() {
		return cityno;
	}

	public void setCityno(int cityno) {
		this.cityno = cityno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewscount() {
		return viewscount;
	}

	public void setViewscount(int viewscount) {
		this.viewscount = viewscount;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
