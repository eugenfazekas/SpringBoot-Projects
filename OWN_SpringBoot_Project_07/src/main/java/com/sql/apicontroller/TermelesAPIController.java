package com.sql.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.service.TermekService;

@RestController
@RequestMapping("termek")
public class TermelesAPIController {
	
	private TermekService termekService;
	
		@Autowired
	public void setTermekService(TermekService termekService) {
		this.termekService = termekService;
	}

	@GetMapping("averageprice")
	public Integer averagePriceOfProducts () {
		
		return termekService.averagePriceOfProducts();
	}

}
