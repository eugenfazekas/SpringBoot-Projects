package com.newsletter.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Subscription {

	@NotBlank
	@Size(min =3 , max =30)
	private String fullNAme;
	

	@NotBlank
	@Email
	private String emailAddress;

	public Subscription() {
		
	}

	public Subscription(String fullNAme, String emailAddress) {
		this.fullNAme = fullNAme;
		this.emailAddress = emailAddress;
	}

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
