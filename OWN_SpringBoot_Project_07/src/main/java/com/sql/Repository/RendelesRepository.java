package com.sql.repository;

import java.sql.SQLException;
import java.util.List;

import com.sql.model.AnyagRendeleshez;
import com.sql.model.Rend_Honap;
import com.sql.model.Rendeles;
import com.sql.model.RendelesCheck;
import com.sql.model.RendelesNev;

public interface RendelesRepository {
	
	public List<Rendeles> findOrderByCharByDate (char character, String date1, String date2);
	
	public List<Rendeles> findProductsUntilDeadline(String date);
	
	public Integer totalPiecesRemainUndelivered();
	
	public List<RendelesNev> findOrderByTwoProductsFromOrder(String product1 , String product2);
		
	public List<RendelesCheck> findTotalPriceOfAnOrderByDate(String date1, String date2);
	
	public List<RendelesCheck> findTotalPriceForAllOrders();
	
	public int[] bacthUpdateForREND_HONAP_Table() throws SQLException;
	
	public List<Rend_Honap> findHighestValueOrder();
	
	public List<AnyagRendeleshez> findMaterialsNeededInDate(String date);

}
