package com.newsletter.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice // Minden Kontrollerre Ervenyesek lesznek az itt felsoroltak,
public class StringTrimingControllerAdvice {
	
	@InitBinder // Ures Karakter levagas
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(false);
		binder.registerCustomEditor(String.class, trimmer);
	}

}
