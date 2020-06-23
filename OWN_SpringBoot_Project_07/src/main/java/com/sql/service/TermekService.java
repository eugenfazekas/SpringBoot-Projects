package com.sql.service;

import java.util.List;

import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;

public interface TermekService {

	public Integer averagePriceOfProducts();
	
	public List<AnyagAzonosito> listOfMaterialIDsByProductCode(String material);
	
	public List<AnyagNev> listOfMaterialNamesByProductName(String material);
}
