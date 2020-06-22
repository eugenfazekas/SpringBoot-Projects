package com.sql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sql.model.Rendeles;
import com.sql.repository.RendelesRepository;
import com.sql.service.RendelesService;

@Service
public class RendelesServiceImpl implements RendelesService {

	private RendelesRepository rendelesRepository;
	
	
	
	public RendelesServiceImpl(RendelesRepository rendelesRepository) {
		this.rendelesRepository = rendelesRepository;
	}

	@Override
	public List<Rendeles> findOrderByCharByDate(char character, String date1, String date2) {

		return rendelesRepository.findOrderByCharByDate(character, date1, date2);
	}

	@Override
	public List<Rendeles> findProductsUntilDeadline(String date) {
	
		return rendelesRepository.findProductsUntilDeadline(date);
	}

}
