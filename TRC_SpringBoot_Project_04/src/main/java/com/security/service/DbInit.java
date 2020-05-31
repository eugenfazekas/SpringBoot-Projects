package com.security.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.security.Repository.UserRepository;
import com.security.model.User;

@Service
public class DbInit implements CommandLineRunner {

	private UserRepository userRepository;

	public DbInit(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		User eugen = new User("Eugen","pass","USER", "");
		User admin = new User("Admin","pass","ADMIN", "ACCES_TEST1,ACCES_TEST2");
		User manager = new User("Manager","pass","MANAGER", "ACCES_TEST1");
		
		List<User> users = Arrays.asList(eugen,admin,manager);
		
		userRepository.saveAll(users);
		
	}

}
