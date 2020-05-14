package com.newsletter.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.newsletter.entity.Subscription;
import com.newsletter.service.exception.SubscriptionAlreadyExistsException;

@Validated
@FunctionalInterface
public interface SubscriptionService {
 
	 void register(@NotNull @Valid Subscription subscription) throws SubscriptionAlreadyExistsException;
}
