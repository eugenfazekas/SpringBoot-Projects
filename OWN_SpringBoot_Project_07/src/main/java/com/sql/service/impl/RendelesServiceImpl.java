package com.sql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sql.model.Rend_Honap;
import com.sql.model.Rendeles;
import com.sql.model.RendelesCheck;
import com.sql.model.RendelesFejTermekLista;
import com.sql.model.RendelesNev;
import com.sql.model.TermekDarab;
import com.sql.repository.RendelesRepository;
import com.sql.repository.RendelesfejRepository;
import com.sql.service.RendelesService;

@Service
public class RendelesServiceImpl implements RendelesService {

	private RendelesRepository rendelesRepository;
	private RendelesfejRepository rendelesfejRepository;
	
	
	

	public RendelesServiceImpl(RendelesRepository rendelesRepository, RendelesfejRepository rendelesfejRepository) {
		this.rendelesRepository = rendelesRepository;
		this.rendelesfejRepository = rendelesfejRepository;
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
		try {
		rendelesRepository.bacthUpdateForREND_HONAP_Table();
		}catch (Exception e) {
			System.out.println("Unique row found");
		}
		return rendelesRepository.findHighestValueOrder();
	}

	@Override
	public List<RendelesFejTermekLista> countProductsOrderdByCustomers() {
		
		return rendelesfejRepository.countProductsOrderdByCustomers();
	}
}
