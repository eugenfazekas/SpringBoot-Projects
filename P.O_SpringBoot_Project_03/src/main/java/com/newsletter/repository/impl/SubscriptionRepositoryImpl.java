package com.newsletter.repository.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.newsletter.entity.Subscription;
import com.newsletter.repository.SubscriptionRepository;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	private Logger log = LoggerFactory.getLogger(getClass());	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Subscription subscription) {
		log.info("'saves' {} now..."+ subscription);
		
		final String sql = "INSERT INTO subscriptions (id,fullname,email) VALUES (?,?,?)";
		final String id = UUID.randomUUID().toString();
		
		jdbcTemplate.update(sql,id,subscription.getFullName(),subscription.getEmailAddress());
	}

}
 