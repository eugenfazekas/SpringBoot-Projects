package com.sql.service;

import java.util.List;

import com.sql.model.RendelesByDateAndName;
import com.sql.model.RendelesByGreatherThen;
import com.sql.model.RendelesFejTermekLista;

public interface RendelesFejService {
	
	public List<RendelesFejTermekLista>countProductsOrderdByCustomers();
	
	public List<RendelesByDateAndName> findOrderByNameAndDate(Integer partnerkod, String date1, String date2);
	
	public List<RendelesByGreatherThen>  findOrderThatOneTypeProductQTYIsGreatherThanX(String date1,String date2, String productcode, Integer qty);
	
}
