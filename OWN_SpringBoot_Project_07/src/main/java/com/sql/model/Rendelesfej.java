package com.sql.model;

import java.util.Date;

public class Rendelesfej {
	
	private String rend_szam;
	
	private String partner_kod;
	 
	private Date date;

	public String getRend_szam() {
		return rend_szam;
	}

	public void setRend_szam(String rend_szam) {
		this.rend_szam = rend_szam;
	}

	public String getPartner_kod() {
		return partner_kod;
	}

	public void setPartner_kod(String partner_kod) {
		this.partner_kod = partner_kod;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Rendelesfej [rend_szam=" + rend_szam + ", partner_kod=" + partner_kod + ", date=" + date + "]";
	}

}
