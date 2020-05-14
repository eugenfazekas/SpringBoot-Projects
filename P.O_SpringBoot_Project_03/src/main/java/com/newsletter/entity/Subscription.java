package com.newsletter.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Subscription {

	@NotBlank
	@Size(min =3 , max =30)
	private String fullName;
	

	@NotBlank
	@Email
	private String emailAddress;

	public Subscription() {
		
	}

	public Subscription(String fullNAme, String emailAddress) {
		this.fullName = fullNAme;
		this.emailAddress = emailAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullNAme) {
		this.fullName = fullNAme;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Subscription [fullName=" + fullName + ", emailAddress=" + emailAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		return true;
	}
	
	
}
