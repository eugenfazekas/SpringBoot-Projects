package com.sec.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sec.entity.User;
import com.sec.repository.UserRepository;

public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  User user = findByEmail(username);
		  if(user == null)
			  throw new UsernameNotFoundException(username);
		return new UserDetailsImpl(user);
	}

}
