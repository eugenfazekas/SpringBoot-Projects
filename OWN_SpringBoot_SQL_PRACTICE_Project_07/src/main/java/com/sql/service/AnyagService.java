package com.sql.service;

import java.util.List;

import com.sql.model.Anyag;

public interface AnyagService {

	List<Anyag> findMaterialBetweenCode(String code1, String code2);
	
	public List<Anyag> findMaterialByUnit(String unit);
	
	public List<Anyag> findMaterialByUnitsCmOrM(String unit1, String unit2);
	
	public Integer countMaterialWhereStorageSmallerThen(String number);
	
	public List<Anyag> findMaterialWithLikeOpeator(String neve);
}
