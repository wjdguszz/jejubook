package com.map.dto;

public class mapDto {

	private int temaNo;
	private String title;
	private double xMap;
	private double yMap;
	private String sortName;
	private String addr;
	private String phone;
	private String homePage;
	private String description;
	
	public mapDto() {
		super();
	}

	public mapDto(int temaNo, String title, double xMap, double yMap, String sortName, String addr, String phone,
			String homePage, String description) {
		super();
		this.temaNo = temaNo;
		this.title = title;
		this.xMap = xMap;
		this.yMap = yMap;
		this.sortName = sortName;
		this.addr = addr;
		this.phone = phone;
		this.homePage = homePage;
		this.description = description;
	}

	public mapDto(int temaNo, String title) {
		super();
		this.temaNo = temaNo;
		this.title = title;
	}

	public int getTemaNo() {
		return temaNo;
	}
	public void setTemaNo(int temaNo) {
		this.temaNo = temaNo;
	}
	public double getxMap() {
		return xMap;
	}
	public void setxMap(double xMap) {
		this.xMap = xMap;
	}
	public double getyMap() {
		return yMap;
	}
	public void setyMap(double yMap) {
		this.yMap = yMap;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
