package com.security.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.Repository.UserRepository;
import com.security.model.User;

@Service
public class DbInit implements CommandLineRunner {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	

	public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}



	@Override
	public void run(String... args) throws Exception {
		
		User eugen = new User("Eugen",passwordEncoder.encode("pass"),"USER", "");
		User admin = new User("Admin",passwordEncoder.encode("pass"),"ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
		User manager = new User("Manager",passwordEncoder.encode("pass"),"MANAGER", "ACCESS_TEST1");
		
		List<User> users = Arrays.asList(eugen,admin,manager);
		
		userRepository.saveAll(users);
		
	}

}
