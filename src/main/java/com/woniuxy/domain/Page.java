package com.woniuxy.domain;

import java.util.List;

public class Page {
	
	private int p;
	private int countRow;
	private int countPages;
	private int size;
	private int prev;
	private int next;
	private int startLine;
	private int startPage;
	private int endPage;
	private List  list;
	private Dept dept;
	private String keywords;
	public Page(int pz, int Row, int s) {
		super();
		this.p = pz;
		this.countRow = Row;
		this.size = s;
		this.countPages = (int) Math.ceil(countRow*1.0/size);
		if(p>countPages) {
			p=countPages;
			}
			
		if(p<1) {
			p=1;
		} 
		prev = p-1;
		next = p+1;
		
		startLine=(p-1)*size;
		
		if(countPages<10) {
			startPage=1;
			endPage=countPages;
		}else{
			startPage = p-5;
			endPage = p+4;
			
			if(startPage<1) {
				startPage=1;
				endPage=10;
			}
			
			if(endPage>countPages) {
				endPage=countPages;
				startPage=countPages-9;
			}
		}
		
	}
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public int getP() {
		return p;
	}
	public void setP(int p) {
		System.out.println("Page.setP()"+p);
		this.p = p;
	}
	public int getCountRow() {
		return countRow;
	}
	public void setCountRow(int countRow) {
		this.countRow = countRow;
	}
	public int getCountPages() {
		return countPages;
	}
	public void setCountPages(int countPages) {
		this.countPages = countPages;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public List  getList() {
		return list;
	}
	public void setList(List  list) {
		this.list = list;
	}
	
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "Page [p=" + p + ", countRow=" + countRow + ", countPages=" + countPages + ", size=" + size + ", prev="
				+ prev + ", next=" + next + ", startLine=" + startLine + ", startPage=" + startPage + ", endPage="
				+ endPage + ", list=" + list + "]";
	}
	
	
	
}
