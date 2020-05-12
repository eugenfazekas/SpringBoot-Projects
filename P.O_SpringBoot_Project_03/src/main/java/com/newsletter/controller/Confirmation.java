package com.newsletter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Confirmation {
	
	@GetMapping("/thank-you")
	public String confirmation() {
		return "confirmation";
	}
	
}
