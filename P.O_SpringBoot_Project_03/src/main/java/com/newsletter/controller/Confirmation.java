package com.newsletter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.newsletter.repository.NewsletterRepository;

@Controller
public class Confirmation {
	

	@Value("${subscription.numebrOfNewsletterSubscriptions}")
	private long numebrOfNewsletterSubscriptions;
	
	@Autowired
	private NewsletterRepository newsLetterRepository;
	
	@GetMapping("/thank-you")
	public String confirmation(Model model) {
		model.addAttribute("numberOfNewLetterSubscriptions", numebrOfNewsletterSubscriptions);
		model.addAttribute("newsletterHighLights", newsLetterRepository.getRecentNewsLetters());
		return "confirmation";
	}
	
}
