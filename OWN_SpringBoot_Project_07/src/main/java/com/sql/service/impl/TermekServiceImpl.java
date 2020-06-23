package com.sql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.repository.TermekRepository;
import com.sql.service.TermekService;

@Service
public class TermekServiceImpl implements TermekService {

	private TermekRepository termekRepository;
	
	@Autowired
	public TermekServiceImpl(TermekRepository termekRepository) {
		this.termekRepository = termekRepository;
	}

	@Override
	public Integer averagePriceOfProducts() {
		
		return termekRepository.averagePriceOfProducts();
	}

}
