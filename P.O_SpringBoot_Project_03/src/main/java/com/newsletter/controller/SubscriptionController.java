package com.newsletter.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.newsletter.entity.Subscription;
import com.newsletter.service.SubscriptionService;
import com.newsletter.service.exception.SubscriptionAlreadyExistsException;

@Controller  
public class SubscriptionController {
	
	private static final String SUBSCRIPTION_FORM = "subscription-form";

	private static final String SUBSCRIPTION_FORM_ATTRIBUTE = "subscriptionForm";

	private static final String PATH_SUBSCRIBE = "/subscribe";

	private Logger logger = LoggerFactory.getLogger(getClass());	
			
	@Autowired 
	private SubscriptionService subscriptionService;	
;	
	@GetMapping(value= {"/",PATH_SUBSCRIBE})
	public String  subscriptionform(@ModelAttribute(SUBSCRIPTION_FORM_ATTRIBUTE)Subscription s) {
		return SUBSCRIPTION_FORM;
	}
	
	@PostMapping(PATH_SUBSCRIBE)
	public String submitsubcription(@ModelAttribute(SUBSCRIPTION_FORM_ATTRIBUTE) @Valid Subscription subscription ,
			BindingResult result, HttpServletResponse response) throws SubscriptionAlreadyExistsException  {
		
		logger.info("User submitted this subscription: {}", subscription);
	
			if(result.hasErrors()) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		result.reject("subscriptionForm.errorincompleteInput");
					return SUBSCRIPTION_FORM;
			} else {
				subscriptionService.register(subscription);
				return "redirect:thank-you";
			}
		
		} 
	 
	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String subscriptionAlreadyExistsException( SubscriptionAlreadyExistsException e ) {
		return "/error-subscription-already-exists";
	}
	
//	@GetMapping("/")
//	@ResponseBody
//	public String index() {
//		return "HelloWorld!";
//	}
	
}
