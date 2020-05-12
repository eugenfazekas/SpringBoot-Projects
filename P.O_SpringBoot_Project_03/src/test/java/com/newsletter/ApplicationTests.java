package com.newsletter;

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
public class ApplicationTests {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Test
	public void testRegistrationSubscription() throws SubscriptionAlreadyExistsException {
		subscriptionService.register(new Subscription("Emily Blunt", "emily@hollywood.com"));
	}

}
