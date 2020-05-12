package com.newsletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.newsletter.entity.Subscription;
import com.newsletter.service.SubscriptionService;
import com.newsletter.service.exception.SubscriptionAlreadyExistsException;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private SubscriptionService service;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Subscription subscription = new Subscription();
		subscription.setFullNAme("John Doe");
		subscription.setEmailAddress("john@mail.com");
		
		try {
			service.register(subscription);
		}catch(SubscriptionAlreadyExistsException duplicate){
			System.err.println("Sorry, there is already a registration"
					+ " with this email address");
		}
	}

}
