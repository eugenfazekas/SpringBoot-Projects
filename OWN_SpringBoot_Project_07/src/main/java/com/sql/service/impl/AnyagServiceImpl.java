package com.sql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sql.model.Anyag;
import com.sql.repository.AnyagRepository;
import com.sql.service.AnyagService;


@Service
public class AnyagServiceImpl implements AnyagService {
	
	private AnyagRepository anyagRepository;
	
	public AnyagServiceImpl(AnyagRepository anyagRepository) {
		this.anyagRepository = anyagRepository;
	}


	@Override
	public List<Anyag> findMaterialBetweenCode(String code1, String code2) {
	
		return anyagRepository.findMaterialBetweenCode(code1, code2);
	}
	
	@Override
	public List<Anyag> findMaterialByUnit(String unit) {
		
		return anyagRepository.findMaterialByUnit(unit);
	}


	@Override
	public List<Anyag> findMaterialByUnitsCmOrM(String unit1, String unit2) {
	
		return anyagRepository.findMaterialByUnitsCmOrM(unit1, unit2);
	}


	

}
