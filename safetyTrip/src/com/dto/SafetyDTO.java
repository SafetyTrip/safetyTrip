package com.dto;

public class SafetyDTO {
	private int sno;
	private int couno;
	private String title;
	private String content;
	private String id;
	private String WrtDt;
	
	public SafetyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SafetyDTO(int sno, int couno, String title, String content, String id, String wrtDt) {
		this.sno = sno;
		this.couno = couno;
		this.title = title;
		this.content = content;
		this.id = id;
		WrtDt = wrtDt;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getCouno() {
		return couno;
	}
	public void setCouno(int couno) {
		this.couno = couno;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWrtDt() {
		return WrtDt;
	}
	public void setWrtDt(String wrtDt) {
		WrtDt = wrtDt;
	}
}
