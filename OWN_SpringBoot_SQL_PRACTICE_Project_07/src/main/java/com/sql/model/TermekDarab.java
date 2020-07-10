package com.sql.model;

public class TermekDarab {

	private String kod;
	
	private String nev;
	
	private Integer darab;

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public Integer getDarab() {
		return darab;
	}

	public void setDarab(Integer darab) {
		this.darab = darab;
	}

	@Override
	public String toString() {
		return "TermekDarab [kod=" + kod + ", nev=" + nev + ", darab=" + darab + "]";
	}

}
