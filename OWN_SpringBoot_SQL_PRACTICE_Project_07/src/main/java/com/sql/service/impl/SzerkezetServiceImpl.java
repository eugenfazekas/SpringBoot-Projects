package com.sql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sql.model.Szerkezet;
import com.sql.repository.SzerkezetRepository;
import com.sql.service.SzerkezetService;

@Service
public class SzerkezetServiceImpl implements SzerkezetService {

	private SzerkezetRepository szerkezetRepository;

	public SzerkezetServiceImpl(SzerkezetRepository szerkezetRepository) {
		this.szerkezetRepository = szerkezetRepository;
	}

	@Override
	public List<Szerkezet> findProductDetails_MaterialsNeededByMaterialId(Integer material) {
		
		return szerkezetRepository.findProductDetails_MaterialsNeededByMaterialId(material);
	}

}
