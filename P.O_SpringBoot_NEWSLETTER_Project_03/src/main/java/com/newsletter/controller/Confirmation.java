package com.newsletter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.newsletter.repository.NewsletterRepository;
import com.newsletter.service.NewsletterService;
import com.newsletter.service.SubscriptionService;

@Controller
public class Confirmation {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private NewsletterService newsLetterService;
	
	@GetMapping("/thank-you")
	public String confirmation(Model model) {
		model.addAttribute("numberOfNewLetterSubscriptions", subscriptionService.getNumberofSubscriptions());
		model.addAttribute("newsletterHighLights", newsLetterService.getRecentNewsletters());
		model.addAttribute("orderProcessingStatus","status.shipped");
		return "confirmation";
	}
	
}
