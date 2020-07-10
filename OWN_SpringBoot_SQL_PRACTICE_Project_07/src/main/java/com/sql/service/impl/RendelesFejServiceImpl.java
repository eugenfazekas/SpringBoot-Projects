package com.sql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sql.model.Partner;
import com.sql.model.RendelesByDateAndName;
import com.sql.model.RendelesByGreatherThen;
import com.sql.model.RendelesFejTermekLista;
import com.sql.repository.RendelesfejRepository;
import com.sql.service.RendelesFejService;

@Service
public class RendelesFejServiceImpl implements RendelesFejService {

	private RendelesfejRepository rendelesfejRepository;

	public RendelesFejServiceImpl(RendelesfejRepository rendelesfejRepository) {

		this.rendelesfejRepository = rendelesfejRepository;
	}

	@Override
	public List<RendelesFejTermekLista> countProductsOrderdByCustomers() {
		
		return rendelesfejRepository.countProductsOrderdByCustomers();
	}

	@Override
	public List<RendelesByDateAndName> findOrderByNameAndDate(Integer partnerkod, String date1, String date2) {
		
		return rendelesfejRepository.findOrderByNameAndDate(partnerkod, date1, date2);
	}

	@Override
	public List<RendelesByGreatherThen> findOrderThatOneTypeProductQTYIsGreatherThanX(String date1, String date2,
			String productcode, Integer qty) {
	
		return rendelesfejRepository.findOrderThatOneTypeProductQTYIsGreatherThanX(date1, date2, productcode, qty);
	}

	@Override
	public List<Partner> findCustomersThatHaveAllOrdersABoveXValue(Integer targetvalue) {
		
		return rendelesfejRepository.findCustomersThatHaveAllOrdersABoveXValue(targetvalue);
	}

	@Override
	public List<Partner> findCustomersThatHaveOrdersBeloveXValue(Integer targetvalue) {
		
		return rendelesfejRepository.findCustomersThatHaveOrdersBeloveXValue(targetvalue);
	}

}
