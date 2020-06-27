package com.sql.service;

import java.util.List;

import com.sql.model.Rendeles;
import com.sql.model.RendelesNev;

public interface RendelesService {

	public List<Rendeles> findOrderByCharByDate(char character, String date1, String date2);

	public List<Rendeles> findProductsUntilDeadline(String date);
	
	public Integer totalPiecesRemainUndelivered();
	
	public List<RendelesNev> findOrderByTwoProductsFromOrder(String product1, String product2);
	
}
