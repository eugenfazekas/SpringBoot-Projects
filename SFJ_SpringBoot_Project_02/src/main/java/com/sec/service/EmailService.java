package com.sec.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String MESSAGE_FROM;
	
	@Value("${EmailService.validation}")   
	private String EmailValidation ;

	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMessage (String email,String fullname, String Key) {
		SimpleMailMessage message = null;
		try {
			message = new SimpleMailMessage();
			message.setFrom(MESSAGE_FROM);
			message.setTo(email);
			message.setSubject("Succesfull Registration");
			message.setText("Dear " +fullname + " \nThank you for you're registering \n \n "+
			 "You can activate you're account by clicking on the link below \n \n"+
			 EmailValidation + Key);
			javaMailSender.send(message);
			log.debug("Sikeres email kuldes");
		}catch(Exception e) {
			log.error("Hiba e-mail kuldesekor a kovetkezo cimre: " +fullname);
		}
	}
}
