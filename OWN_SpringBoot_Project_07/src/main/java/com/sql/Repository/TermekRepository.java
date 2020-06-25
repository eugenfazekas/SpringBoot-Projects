package com.sql.repository;

import java.util.List;

import com.sql.model.TermekNev;

public interface TermekRepository {
	
	public Integer averagePriceOfProducts();
	
	public List<TermekNev> findProductsByWhatContainsMaterialID (Integer maerialId);

}
