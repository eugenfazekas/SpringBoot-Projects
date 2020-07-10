package com.newsletter.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsletter.entity.Newsletter;
import com.newsletter.repository.NewsletterRepository;
import com.newsletter.service.NewsletterService;

@Service
public class NewslettersServiceImpl implements NewsletterService{

	@Autowired 
	private NewsletterRepository newsletterRepository;
	
	@Override
	public @NotNull List<Newsletter> getRecentNewsletters() {
		
		final LocalDate today = LocalDate.now();
		final LocalDate fromDate = today.minusMonths(30);
		
		return newsletterRepository.getNewsLettersForPeriodOrderedByDescendingPublishingDateLimitedByMaxRecordCount(fromDate, today, 3);
		
	}

}
