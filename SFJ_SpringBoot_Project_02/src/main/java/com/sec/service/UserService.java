package com.sec.service;

import org.springframework.stereotype.Service;

import com.sec.entity.User;

@Service
public interface UserService {

	public User findByEmail(String email);
}
