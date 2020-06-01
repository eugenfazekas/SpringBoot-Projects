package com.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.Repository.UserRepository;
import com.security.model.User;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

	private UserRepository userReposiyotry;

	public UserPrincipalDetailsService(UserRepository userReposiyotry) {
		this.userReposiyotry = userReposiyotry;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userReposiyotry.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		
		return userPrincipal ;
	}

}
