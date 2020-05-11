package com.sec.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sec.entity.Role;
import com.sec.entity.User;
import com.sec.service.EmailService;
import com.sec.service.UserService;

@Controller
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private UserService userService;

	@Autowired
	@Qualifier("UserServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/bloggers")
	public String bloggers(){
		return "bloggers";
	}
	
	@RequestMapping("/stories")
	public String stories(){
		return "stories";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "registration";
	}
	
	//@PostMapping("/reg")
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String submit(@ModelAttribute User user){
		log.info("Uj Felhasznalo:");
		log.debug("Nev: "+user.getFullName());
		log.debug("Email: "+user.getEmail());
		log.debug("Jelszo: "+user.getPassword());
		userService.registerUser(user);
		return "auth/login";
	}
	
}
