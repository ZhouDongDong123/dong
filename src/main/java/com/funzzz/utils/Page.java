package com.funzzz.utils;

import java.util.List;

public class Page<T> {
	private int currentPage;
	private int pageSize;
	private int currentRecording;
	public int getCurrentRecording(){
		currentRecording = (currentPage-1)*pageSize;
		return currentRecording;
		
	}
	
	private List<T> list;
	private int totalRecord;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = (totalRecord+pageSize-1)/pageSize;
	}
	public Page(int currentPage, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	//get 上一页
	public int getFrontPage(){
		return currentPage>1 ?
					currentPage-1:1;
	}
	//get 下一页
	public int getNextPage(){
		return currentPage<totalRecord ?
					currentPage+1:totalRecord;
	}
}
