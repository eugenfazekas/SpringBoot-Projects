package com.newsletter.service;

import com.newsletter.entity.Subscription;
import com.newsletter.service.exception.SubscriptionAlreadyExistsException;

public interface SubscriptionService {
 
	 void register(Subscription subscription) throws SubscriptionAlreadyExistsException;
}
