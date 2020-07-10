package com.sql.repository;

import java.util.List;

import com.sql.model.Termek;
import com.sql.model.TermekAr;
import com.sql.model.TermekBonyolultsag;
import com.sql.model.TermekDarab;
import com.sql.model.TermekGyarthato;
import com.sql.model.TermekNev;
import com.sql.model.TermekNev_AnyagAzonosito;
import com.sql.model.TermekRendelesek;
import com.sql.model.TermekUtolsoRendeles;
import com.sql.model.TermekVelemeny;

public interface TermekRepository {
	
	public Integer averagePriceOfProducts();
	
	public List<TermekNev> findProductsByWhatContainsMaterialID (Integer maerialId);
	
	public List<Termek> findProductsWhatCanBeOrderdButNotOrderedYet();
	
	public List<TermekDarab> findProductsWhatWasOrderAndHerQuatityAndCanBeOrdered();
	
	public List<TermekDarab> countMaterialsForAProduct();
	
	public List<TermekDarab> findProductsThatNeedMoreThenTwoMaterials();
	
	public List<TermekDarab> findProductThatHaveTheMostTypeOfMaterials();
	
	public List<TermekNev> findProductsThatDontHavaMaterialListDescription();
	
	public List<TermekGyarthato> listProductsThatCanBeManufacturedOrNot();
	
	public List<TermekAr> listProductsPrice();
	
	public int[] bacthUpdateProductsPrice();
	
	public List<TermekVelemeny> productsPriceOpinion();
	
	public List<TermekBonyolultsag> listProductsComplexityWithAutoGeneratedIDs();
	
	public List<TermekRendelesek> listProductsWasOrderd_ProductsWasNotOrdered_OrdersWithWrongOrderName();
	
	public List<TermekUtolsoRendeles> findProductsLastOrderdDate();

}
