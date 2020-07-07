package com.sql.repository;

import java.util.List;

import com.sql.model.Partner;
import com.sql.model.RendelesByDateAndName;
import com.sql.model.RendelesByGreatherThen;
import com.sql.model.RendelesFejTermekLista;

public interface RendelesfejRepository {
	
	public List<RendelesFejTermekLista> countProductsOrderdByCustomers();
	
	public List<RendelesByDateAndName>  findOrderByNameAndDate(Integer partnerkod, String date1, String date2);
	
	public List<RendelesByGreatherThen>  findOrderThatOneTypeProductQTYIsGreatherThanX(String date1,String date2, String productcode, Integer qty);
	
	public List<Partner> findCustomersThatHaveAllOrdersABoveXValue(Integer targetvalue);
	
	public List<Partner> findCustomersThatHaveOrdersBeloveXValue(Integer targetvalue);

}
