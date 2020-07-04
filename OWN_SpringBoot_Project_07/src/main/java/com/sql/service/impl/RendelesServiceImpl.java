package com.sql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sql.model.Rend_Honap;
import com.sql.model.Rendeles;
import com.sql.model.RendelesCheck;
import com.sql.model.RendelesNev;
import com.sql.model.TermekDarab;
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

	@Override
	public Integer totalPiecesRemainUndelivered() {
		
		return rendelesRepository.totalPiecesRemainUndelivered();
	}

	@Override
	public List<RendelesNev> findOrderByTwoProductsFromOrder(String product1, String product2) {
	
		return rendelesRepository.findOrderByTwoProductsFromOrder(product1, product2);
	}
	@Override
	public List<RendelesCheck> findTotalPriceOfAnOrderByDate(String date1, String date2) {
	
		return rendelesRepository.findTotalPriceOfAnOrderByDate(date1, date2);
	}

	@Override
	public List<RendelesCheck> findTotalPriceForAllOrders() {
		
		return rendelesRepository.findTotalPriceForAllOrders();
	}

	@Override
	public List<Rend_Honap> findHighestValueOrder() {
		rendelesRepository.bacthUpdateForREND_HONAP_Table();
		
		return rendelesRepository.findHighestValueOrder();
	}
}
