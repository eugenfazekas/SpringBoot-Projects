package com.newsletter.repository;

import org.springframework.stereotype.Repository;

import com.newsletter.entity.Subscription;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	@Override
	public void save(Subscription subscription) {
System.out.println("SubScriptionRepositoryImpl 'saves' "+ subscription);

	}

}
