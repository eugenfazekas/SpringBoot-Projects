package com.sql.service;

import java.util.List;

import com.sql.model.Rendeles;

public interface RendelesService {

	public List<Rendeles> findOrderByCharByDate(char character, String date1, String date2);

	public List<Rendeles> findProductsUntilDeadline(String date);
	
}
