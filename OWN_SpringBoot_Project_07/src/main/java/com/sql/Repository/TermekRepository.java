package com.sql.repository;

import java.util.List;

import com.sql.model.Termek;
import com.sql.model.TermekDarab;
import com.sql.model.TermekNev;

public interface TermekRepository {
	
	public Integer averagePriceOfProducts();
	
	public List<TermekNev> findProductsByWhatContainsMaterialID (Integer maerialId);
	
	public List<Termek> findProductsWhatCanBeOrderdButNotOrderedYet();
	
	public List<TermekDarab> findProductsWhatWasOrderAndHerQuatityAndCanBeOrdered();
	
	public List<TermekDarab> countMaterialsForAProduct();
	
	public List<TermekDarab> findProductsThatNeedMoreThenTwoMaterials();

}
