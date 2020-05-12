package com.newsletter.repository;

import java.util.List;

import com.newsletter.entity.Newsletter;

public interface NewsletterRepository {

	List<Newsletter> getRecentNewsLetters();
	
}
