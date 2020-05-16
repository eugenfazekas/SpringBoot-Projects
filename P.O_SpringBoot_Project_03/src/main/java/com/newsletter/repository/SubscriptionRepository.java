package com.newsletter.repository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.newsletter.entity.Subscription;

@Validated
public interface SubscriptionRepository {

	void save(@NotNull @Valid Subscription subscription);
	
	@Min(0)
	long count();
}
