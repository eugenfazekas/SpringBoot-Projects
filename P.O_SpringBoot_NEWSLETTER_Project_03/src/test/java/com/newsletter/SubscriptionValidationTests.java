package com.newsletter;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.newsletter.entity.Subscription;
import com.newsletter.service.SubscriptionService;
import com.newsletter.service.exception.SubscriptionAlreadyExistsException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionValidationTests {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Test(expected=ConstraintViolationException.class)
	public void testRegistrationSubscriptionWithNull() throws SubscriptionAlreadyExistsException {
		subscriptionService.register(null);
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testRegistrationSubscriptionWithNameOfSpaceOnly() throws SubscriptionAlreadyExistsException {
		subscriptionService.register(new Subscription("     ", "emily@hollywood.com"));
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testRegistrationSubscriptionIvalidEmailAddressFormat() throws SubscriptionAlreadyExistsException {
		subscriptionService.register(new Subscription("Emily Blunt", "hollywood.com"));
	}

}
