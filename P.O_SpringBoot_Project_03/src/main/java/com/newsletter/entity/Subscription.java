package com.newsletter.entity;

public class Subscription {

	private String fullNAme;
	
	private String emailAddress;

	public String getFullNAme() {
		return fullNAme;
	}

	public void setFullNAme(String fullNAme) {
		this.fullNAme = fullNAme;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Subscription [fullNAme=" + fullNAme + ", emailAddress=" + emailAddress + "]";
	}
	
	
}
