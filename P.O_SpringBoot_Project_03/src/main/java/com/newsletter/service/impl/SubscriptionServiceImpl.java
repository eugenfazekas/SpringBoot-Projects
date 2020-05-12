package com.newsletter.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsletter.entity.Subscription;
import com.newsletter.repository.SubscriptionRepository;
import com.newsletter.service.SubscriptionService;
import com.newsletter.service.exception.SubscriptionAlreadyExistsException;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Override
	public void register(Subscription subscription) throws SubscriptionAlreadyExistsException {
	log.info("SubscriptionImpl registers "+ subscription);

	try {
	subscriptionRepository.save(subscription);
	}catch(RuntimeException duplicate) {
		log.error("Error during persisting the subscription", duplicate);
		throw new SubscriptionAlreadyExistsException(
				"Subscription already exists with email: "+
		subscription.getEmailAddress());
		}
	}
}
