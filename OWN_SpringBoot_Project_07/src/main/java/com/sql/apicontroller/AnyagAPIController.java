package com.sql.apicontroller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.model.Anyag;
import com.sql.service.AnyagService;

@RestController
@RequestMapping("anyag")
public class AnyagAPIController {
	
	private AnyagService anyagService;
	
	@Autowired
	public void setAnyagService(AnyagService anyagService) {
		this.anyagService = anyagService;
	}

	@GetMapping(path = "/code/{code1}/{code2}")
	public List<Anyag> findMaterialBetweenCode(@PathVariable("code1") String code1,@PathVariable("code2") String code2,HttpServletResponse response) {
		
		return anyagService.findMaterialBetweenCode(code1, code2);

	}
	
	@GetMapping(path = "/unit/{unit}")
	public List<Anyag> findMaterialByUnit(@PathVariable("unit") String unit,HttpServletResponse response) {
		
		return anyagService.findMaterialByUnit(unit);
	}
	
	@GetMapping(path = "/units/{unit1}/{unit2}")
	public List<Anyag> findMaterialByUnits(@PathVariable("unit1") String unit1,@PathVariable("unit2") String unit2,HttpServletResponse response) {
		
		return anyagService.findMaterialByUnitsCmOrM(unit1, unit2);
	}
	
}