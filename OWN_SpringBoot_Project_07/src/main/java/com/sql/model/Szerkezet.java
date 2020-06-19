package com.sql.model;

public class Szerkezet {

	private String kod;
	
	private Integer azonosito;
	
	private Integer mennyiseg;

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public Integer getAzonosito() {
		return azonosito;
	}

	public void setAzonosito(Integer azonosito) {
		this.azonosito = azonosito;
	}

	public Integer getMennyiseg() {
		return mennyiseg;
	}

	public void setMennyiseg(Integer mennyiseg) {
		this.mennyiseg = mennyiseg;
	}

	@Override
	public String toString() {
		return "Szerkezet [kod=" + kod + ", azonosito=" + azonosito + ", mennyiseg=" + mennyiseg + "]";
	}
	
}
