package com.newsletter.service.exception;

public class SubscriptionAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public SubscriptionAlreadyExistsException(String message) {
		super(message);
	}
}
