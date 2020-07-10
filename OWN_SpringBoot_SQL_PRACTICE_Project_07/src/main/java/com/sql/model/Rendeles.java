package com.sql.model;

import java.util.Date;

public class Rendeles {

	private String rend_szam;
	
	private String kod;
	
	private Integer darab;
	
	private Date date;
	
	private Boolean kesz;

	public String getRend_szam() {
		return rend_szam;
	}

	public void setRend_szam(String rend_szam) {
		this.rend_szam = rend_szam;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public Integer getDarab() {
		return darab;
	}

	public void setDarab(Integer darab) {
		this.darab = darab;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getKesz() {
		return kesz;
	}

	public void setKesz(Boolean kesz) {
		this.kesz = kesz;
	}

	@Override
	public String toString() {
		return "Rendeles [rend_szam=" + rend_szam + ", kod=" + kod + ", darab=" + darab + ", date=" + date + ", kesz="
				+ kesz + "]";
	}

}
