package com.newsletter.repository.impl;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import com.newsletter.entity.Newsletter;
import com.newsletter.repository.NewsletterRepository;


@Repository
@ConfigurationProperties(prefix = "communications")
public class ConfigurationBasedNewsletterRepositoryImpl implements NewsletterRepository {

	
	private List<Newsletter> recentNewsLetters;
	
	@Override
	public List<Newsletter> getRecentNewsLetters() {
		
		return recentNewsLetters;
	}

	public void setRecentNewsLetters(List<Newsletter> recentnewsletters) {
		this.recentNewsLetters = recentnewsletters;
	}

}
