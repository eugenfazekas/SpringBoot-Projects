package com.sql.repository;

import java.util.List;

import com.sql.model.Anyag;

public interface AnyagRepository {

	public List<Anyag> findMaterialBetweenCode(String code1, String code2);
	
	public List<Anyag> findMaterialByUnit(String unit);

	public List<Anyag> findMaterialByUnitsCmOrM(String unit1, String unit2);
}