package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("managemet")
public class ManagementController {

	@GetMapping("index")
		public String index () {
			return "management/index";
		}
	}
	

