package com.sql.service;

import java.util.List;

import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;
import com.sql.model.Termek;
import com.sql.model.TermekDarab;
import com.sql.model.TermekNev;
import com.sql.model.TermekNev_AnyagAzonosito;

public interface TermekService {

	public Integer averagePriceOfProducts();
	
	public List<AnyagAzonosito> listOfMaterialIDsByProductCode(String material);
	
	public List<AnyagNev> listOfMaterialNamesByProductName(String material);
	
	public List<TermekNev> findProductsByWhatContainsMaterialID (Integer maerialId);
	
	public List<TermekNev_AnyagAzonosito> findProductsWithMaterialsListByOneMaterialID(Integer materialID);
	
	public List<Termek> findProductsWhatCanBeOrderdButNotOrderedYet();

	public List<TermekDarab>findProductsWhatWasOrderAndHerQuatityAndCanBeOrdered();
	
	public List<TermekDarab> countMaterialsForAProduct();
	
	public List<TermekDarab> findProductsThatNeedMoreThenTwoMaterials();
}
