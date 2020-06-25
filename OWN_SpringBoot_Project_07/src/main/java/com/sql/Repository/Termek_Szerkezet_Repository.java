package com.sql.repository;

import java.util.List;

import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;
import com.sql.model.TermekNev_AnyagAzonosito;

public interface Termek_Szerkezet_Repository {

	public List<AnyagAzonosito> listOfMaterialIDsByProductCode(String material);
	
	public List<AnyagNev> listOfMaterialNamesByProductName(String material);
	
	public List<TermekNev_AnyagAzonosito> findProductsWithMaterialsListByOneMaterialID(Integer materialID);
	
}
