package com.newsletter.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.newsletter.entity.Subscription;
import com.newsletter.repository.SubscriptionRepository;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	private Logger log = LoggerFactory.getLogger(getClass());	
	
	@Override
	public void save(Subscription subscription) {
		log.info("'saves' {} now..."+ subscription);

	}

}
