package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class } )
public class TrcSpringBootProject04Application {

	public static void main(String[] args) {
		SpringApplication.run(TrcSpringBootProject04Application.class, args);
	}

}
