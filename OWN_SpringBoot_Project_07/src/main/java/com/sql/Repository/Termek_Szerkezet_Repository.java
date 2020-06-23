package com.sql.repository;

import java.util.List;

import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;

public interface Termek_Szerkezet_Repository {

	public List<AnyagAzonosito> listOfMaterialIDsByProductCode(String material);
	
	public List<AnyagNev> listOfMaterialNamesByProductName(String material);
	
}
