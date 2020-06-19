package com.sql.model;

public class Anyag {

	private Integer azonosito;
	
	private String neve;
	
	private String mert_egys;
	
	private Double egys_ar;
	
	private Integer keszlet;

	public Integer getAzonosito() {
		return azonosito;
	}

	public void setAzonosito(Integer azonosito) {
		this.azonosito = azonosito;
	}

	public String getNeve() {
		return neve;
	}

	public void setNeve(String neve) {
		this.neve = neve;
	}

	public String getMert_egys() {
		return mert_egys;
	}

	public void setMert_egys(String mert_egys) {
		this.mert_egys = mert_egys;
	}

	public Double getEgys_ar() {
		return egys_ar;
	}

	public void setEgys_ar(Double egys_ar) {
		this.egys_ar = egys_ar;
	}

	public Integer getKeszlet() {
		return keszlet;
	}

	public void setKeszlet(Integer keszlet) {
		this.keszlet = keszlet;
	}

	@Override
	public String toString() {
		return "Anyag [azonosito=" + azonosito + ", neve=" + neve + ", mert_egys=" + mert_egys + ", egys_ar=" + egys_ar
				+ ", keszlet=" + keszlet + "]";
	}

}
