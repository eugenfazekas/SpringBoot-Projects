package com.sql.repository;

import java.util.List;

import com.sql.model.Rendeles;

public interface RendelesRepository {
	
	public List<Rendeles> findOrderByCharByDate (char character, String date1, String date2);
	
	public List<Rendeles> findProductsUntilDeadline(String date);

}
