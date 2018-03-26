package com.dto;

public class QnADTO {
	
	private int qno;
	private int uno;
	private int hno;
	private String question;
	private int qopen;
	private String createDate;
	
	public QnADTO() {
	}
	public QnADTO(int qno, int uno, int hno, String question, int qopen, String createDate) {
		super();
		this.qno = qno;
		this.uno = uno;
		this.hno = hno;
		this.question = question;
		this.qopen = qopen;
		this.createDate = createDate;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQopen() {
		return qopen;
	}

	public void setQopen(int qopen) {
		this.qopen = qopen;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	
}
