package com.sec.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sec.entity.User;

@Controller
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
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
		log.debug("Jelszo: "+user.getPassword());
		return "auth/login";
	}
	
}
