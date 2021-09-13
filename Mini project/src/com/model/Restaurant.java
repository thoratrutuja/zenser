package com.model;

import java.time.LocalTime;

public class Restaurant {


	int Rid;
	String Rname;
	LocalTime openingTime;
	LocalTime closingTime;
	long Rphno;
	String Radd;
	String cuisine;
	public int getRid() {
		return Rid;
	}
	public void setRid(int rid) {
		Rid = rid;
	}
	public String getRname() {
		return Rname;
	}
	public void setRname(String rname) {
		Rname = rname;
	}
	public LocalTime getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}
	public LocalTime getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}
	public long getRphno() {
		return Rphno;
	}
	public void setRphno(long rphno) {
		Rphno = rphno;
	}
	public String getRadd() {
		return Radd;
	}
	public void setRadd(String radd) {
		Radd = radd;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public Restaurant(int rid, String rname, LocalTime openingTime, LocalTime closingTime, long rphno, String radd,
			String cuisine) {
		super();
		Rid = rid;
		Rname = rname;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		Rphno = rphno;
		Radd = radd;
		this.cuisine = cuisine;
	}
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Restaurant [Rid=" + Rid + ", Rname=" + Rname + ", openingTime=" + openingTime + ", closingTime="
				+ closingTime + ", Rphno=" + Rphno + ", Radd=" + Radd + ", cuisine=" + cuisine + "]";
	}
	
	

}
