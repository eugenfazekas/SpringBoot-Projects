package com.newsletter.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.newsletter.entity.Newsletter;

@Validated
public interface NewsletterService {

	@NotNull
	List<Newsletter> getRecentNewsletters();
}
