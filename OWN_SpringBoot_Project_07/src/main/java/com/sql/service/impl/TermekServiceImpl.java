package com.sql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.model.Anyag;
import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;
import com.sql.repository.TermekRepository;
import com.sql.repository.Termek_Szerkezet_Repository;
import com.sql.service.TermekService;

@Service
public class TermekServiceImpl implements TermekService {

	private TermekRepository termekRepository;
	private Termek_Szerkezet_Repository termek_Szerkezet_Repository ;
	
	@Autowired
	

	@Override
	public Integer averagePriceOfProducts() {
		
		return termekRepository.averagePriceOfProducts();
	}

	public TermekServiceImpl(TermekRepository termekRepository, Termek_Szerkezet_Repository termek_Szerkezet_Repository) {
		this.termekRepository = termekRepository;
		this.termek_Szerkezet_Repository = termek_Szerkezet_Repository;
	}

	@Override
	public List<AnyagAzonosito> listOfMaterialIDsByProductCode(String material) {
		
		return termek_Szerkezet_Repository.listOfMaterialIDsByProductCode(material);
	}

	@Override
	public List<AnyagNev> listOfMaterialNamesByProductName(String material) {
		
		return termek_Szerkezet_Repository.listOfMaterialNamesByProductName(material);
	}

}
