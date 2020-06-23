package com.sql.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;
import com.sql.service.TermekService;

@RestController
@RequestMapping("termek")
public class TermekAPIController {
	
	private TermekService termekService;
	
		@Autowired
	public void setTermekService(TermekService termekService) {
		this.termekService = termekService;
	}

	@GetMapping("averageprice")
	public Integer averagePriceOfProducts () {
		
		return termekService.averagePriceOfProducts();
	}
	
	@GetMapping("materialidlist/{productId}")
	public List<AnyagAzonosito> listOfMaterialIDsByProductCode (@PathVariable("productId") String productId) {
		
		return termekService.listOfMaterialIDsByProductCode(productId);
	}
	
	@GetMapping("materiallist/{product}")
	public List<AnyagNev> listOfMaterialNamesByProductName(@PathVariable("product") String product) {
		
		return termekService.listOfMaterialNamesByProductName(product);
	}
	
	

}
