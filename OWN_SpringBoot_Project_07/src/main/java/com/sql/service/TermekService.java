package com.sql.service;

import java.util.List;

import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;
import com.sql.model.Termek;
import com.sql.model.TermekDarab;
import com.sql.model.TermekGyarthato;
import com.sql.model.TermekNev;
import com.sql.model.TermekNev_AnyagAzonosito;
import com.sql.model.TermekVelemeny;

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
	
	public List<TermekDarab> findProductThatHaveTheMostTypeOfMaterials();
	
	public List<TermekNev> findProductsThatDontHavaMaterialListDescription();
	
	public List<TermekGyarthato> listProductsThatCanBeManufacturedOrNot();
	
	public List<TermekVelemeny> productsPriceOpinion();
}
