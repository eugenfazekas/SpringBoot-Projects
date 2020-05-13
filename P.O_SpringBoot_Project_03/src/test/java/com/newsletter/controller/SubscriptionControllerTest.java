package com.newsletter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.Locale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.newsletter.entity.Subscription;

@RunWith(SpringRunner.class)
@WebMvcTest(SubscriptionController.class)
public class SubscriptionControllerTest {

	
	private static final String PATH_SUBSCRIPTION_FORM = "/subscribe";
	private static final String PATH_CONFIRMATION_PAGE = "/thank-you";
	
	private static final String FORM_FIELD_FULL_NAME   = "fullName";
	private static final String FORM_FIELD_EMAIL_ADDRESS = "emailAddress";
	
	private static final String VIEW_SUBSCRIPTION_FORM = "subscription-form";
	private static final String VIEW_CONFIRMATION_PAGE = "confirmation";
	
	private static final String CONTENTTYPE_HTML_UTF8 = "text/html;charset=UTF-8";
	
	@Autowired
	private MockMvc mvc;
	
	private ResultActions result;
	
	private void given_theUserIsOnTheSubscriptionPage() throws Exception {
		
		result = mvc.perform(
				get(PATH_SUBSCRIPTION_FORM)
				.accept(MediaType.TEXT_HTML)
				.locale(Locale.ENGLISH))
				
				.andDo(print())
				.andExpect(content().contentType(CONTENTTYPE_HTML_UTF8)) 
				.andExpect(status().isOk())
				.andExpect(view().name(VIEW_SUBSCRIPTION_FORM));
	}
	
	@Test
	public void testSubscriptionFormIsEmptyWhenSubscriptionFormIsOpened() throws Exception{
		
		given_theUserIsOnTheSubscriptionPage();
		then_theFormContains(new Subscription("",""));
	}

	private void then_theFormContains(final Subscription subscription) throws Exception {
		result.andExpect(xpath("//input[@name='" +FORM_FIELD_FULL_NAME+ "']/@value").string(subscription.getFullNAme()))
			  .andExpect(xpath("//input[@name='" +FORM_FIELD_EMAIL_ADDRESS + "']/@value").string(subscription.getEmailAddress()));
	}
	
	private void when_userSubmitSubscriptionFormContaining(final Subscription subscriptionformInput) throws Exception{
		
		result = mvc.perform(
				post(PATH_SUBSCRIPTION_FORM)
				.accept(MediaType.TEXT_HTML)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param(FORM_FIELD_FULL_NAME, subscriptionformInput.getFullNAme())
				.param(FORM_FIELD_EMAIL_ADDRESS, subscriptionformInput.getEmailAddress()));
	}
	private void then_theUserIsRedirectedToTheConfirmationPage() throws Exception {
		
		result.andDo(print())
			  .andExpect(status().is3xxRedirection())
			  .andExpect(redirectedUrl(PATH_CONFIRMATION_PAGE));		  
	}
	@Test
	public void testSubscriptionFormTakesCorrectlySubmittedData() throws Exception{
		given_theUserIsOnTheSubscriptionPage();
		when_userSubmitSubscriptionFormContaining(new Subscription("Emma Watson","emma@hollywood.com"));
		then_theUserIsRedirectedToTheConfirmationPage();
	}
	
	private void then_theRegistrationIsRefusedDueToBadRequest() throws Exception{
		result.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(xpath("//div[@class='formErrorMessage']").exists());
	}
	
	private void then_fieldErrorDisplayedFor(String fieldName) throws Exception{
		result.andExpect(xpath("//div[@class='fieldErrorMessage']/following-sibling::*[position()=1][@name='" + fieldName+ "']").exists());
	}
	
	private void then_fieldErrorNotDisplayedFor(String fieldName) throws Exception{
		result.andExpect(xpath("//div[@class='fieldErrorMessage']/following-sibling::*[position()=1][@name='" + fieldName+ "']").doesNotExist());
	}
	
	@Test
	public void testSubscriptionFormRefusesInputWithMissingFullName() throws Exception{
		given_theUserIsOnTheSubscriptionPage();
		
		final Subscription subscriptionWithMissingName = new Subscription("","emma@hollywood.com");
		when_userSubmitSubscriptionFormContaining(subscriptionWithMissingName);
		
		then_theRegistrationIsRefusedDueToBadRequest();
		then_fieldErrorDisplayedFor(FORM_FIELD_FULL_NAME);
		then_fieldErrorNotDisplayedFor(FORM_FIELD_EMAIL_ADDRESS);
		then_theFormContains(subscriptionWithMissingName);
	}
}
