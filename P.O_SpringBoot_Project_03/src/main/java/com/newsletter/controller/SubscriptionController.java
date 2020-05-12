package com.newsletter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.newsletter.entity.Subscription;

@Controller  
public class SubscriptionController {

	private static final String PATH_SUBSCRIBE = "/subscribe";

	private final Logger logger = LoggerFactory.getLogger(getClass())
;	
	@GetMapping(value= {"/",PATH_SUBSCRIBE})
	public String  subscriptionform() {
		return "subscription-form";
	}
	
	@PostMapping(PATH_SUBSCRIBE)
	public String submitsubcription(Subscription subscription) {
		logger.info("User submitted this subscription: {}", subscription);
		return "redirect:/thank-you";
	}
	
//	@GetMapping("/")
//	@ResponseBody
//	public String index() {
//		return "HelloWorld!";
//	}
	
}
