package com.dto;

import java.util.List;

public class QnAPageDTO {
	
	private List<QnAImgDTO> imglist; //QnAImg List
	private List<QnADTO> list; // QnA List
	private int perPage = 3;  // Page 갯수
	private int totalCount;   // Total
	private int curPage;      // Current
	
	public QnAPageDTO() {
	}
	public QnAPageDTO(List<QnAImgDTO> imglist, List<QnADTO> list, int perPage, int totalCount, int curPage) {
		super();
		this.imglist = imglist;
		this.list = list;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.curPage = curPage;
	}
	public List<QnAImgDTO> getImglist() {
		return imglist;
	}
	public void setImglist(List<QnAImgDTO> imglist) {
		this.imglist = imglist;
	}
	public List<QnADTO> getList() {
		return list;
	}
	public void setList(List<QnADTO> list) {
		this.list = list;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	
}
