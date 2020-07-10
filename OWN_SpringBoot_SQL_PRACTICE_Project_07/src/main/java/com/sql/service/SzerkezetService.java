package com.sql.service;

import java.util.List;

import com.sql.model.Szerkezet;

public interface SzerkezetService {

	
	public List<Szerkezet> findProductDetails_MaterialsNeededByMaterialId(Integer material);
}
