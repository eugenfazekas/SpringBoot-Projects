package com.sql.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.model.Szerkezet;
import com.sql.service.SzerkezetService;

@RestController
@RequestMapping("szerkezet")
public class SzerkezetController {
	
	private SzerkezetService szerkezetService;

	@Autowired
	public void setSzerkezetService(SzerkezetService szerkezetService) {
		this.szerkezetService = szerkezetService;
	}
	
	@GetMapping("findProductDetails_MaterialsNeededByMaterialId/{materialID}")
	public List<Szerkezet> findProductDetails_MaterialsNeededByMaterialId(@PathVariable("materialID") Integer materialID) {
		
		return szerkezetService.findProductDetails_MaterialsNeededByMaterialId(materialID);
	}
	
}
