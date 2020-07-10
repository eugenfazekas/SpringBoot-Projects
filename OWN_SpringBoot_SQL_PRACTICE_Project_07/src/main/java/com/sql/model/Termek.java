package com.sql.model;

public class Termek {

	private String kod;
	
	private String nev;
	
	private Integer ar;

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

	public Integer getAr() {
		return ar;
	}

	public void setAr(Integer ar) {
		this.ar = ar;
	}

	@Override
	public String toString() {
		return "Termek [kod=" + kod + ", nev=" + nev + ", ar=" + ar + "]";
	}
}
