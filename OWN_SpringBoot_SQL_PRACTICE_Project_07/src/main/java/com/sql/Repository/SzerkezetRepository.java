package com.sql.repository;

import java.util.List;

import com.sql.model.Szerkezet;

public interface SzerkezetRepository {
	
	public List<Szerkezet> findProductDetails_MaterialsNeededByMaterialId(Integer material);

}
