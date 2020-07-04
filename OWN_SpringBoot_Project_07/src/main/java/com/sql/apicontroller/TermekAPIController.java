package com.sql.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;
import com.sql.model.Termek;
import com.sql.model.TermekDarab;
import com.sql.model.TermekNev;
import com.sql.model.TermekNev_AnyagAzonosito;
import com.sql.service.TermekService;

@RestController
@RequestMapping("termek")
public class TermekAPIController {
	
	private TermekService termekService;
	
		@Autowired
	public void setTermekService(TermekService termekService) {
		this.termekService = termekService;
	}

	@GetMapping("averageprice")
	public Integer averagePriceOfProducts () {
		
		return termekService.averagePriceOfProducts();
	}
	
	@GetMapping("materialidlist/{productId}")
	public List<AnyagAzonosito> listOfMaterialIDsByProductCode (@PathVariable("productId") String productId) {
		
		return termekService.listOfMaterialIDsByProductCode(productId);
	}
	
	@GetMapping("materiallist/{product}")
	public List<AnyagNev> listOfMaterialNamesByProductName(@PathVariable("product") String product) {
		
		return termekService.listOfMaterialNamesByProductName(product);
	}
	
	@GetMapping("productbymaterialid/{materialID}")
	public List<TermekNev> findProductsByWhatContainsMaterialID(@PathVariable("materialID") Integer materialID) {
		
		return termekService.findProductsByWhatContainsMaterialID(materialID);
	}
	
	@GetMapping("productsallmaterialsbymateialid/{materialID}")
	public List<TermekNev_AnyagAzonosito> findProductsWithMaterialsListByOneMaterialID(@PathVariable("materialID") Integer materialID) {
		
		return termekService.findProductsWithMaterialsListByOneMaterialID(materialID);
	}
	
	@GetMapping("notordered")
	public List<Termek> findProductsWhatCanBeOrderdButNotOrderedYet() {
		
		return termekService.findProductsWhatCanBeOrderdButNotOrderedYet();
	}

	@GetMapping("orderedproductscounted")
	public List<TermekDarab> findProductsWhatWasOrderAndHerQuatityAndCanBeOrdered() {
		
	return termekService.findProductsWhatWasOrderAndHerQuatityAndCanBeOrdered();
	}
	
	@GetMapping("countedmaterialtypesforaproduct")
	public List<TermekDarab> countMaterialsForAProduct() {
	
		return termekService.countMaterialsForAProduct();
	}
	
	@GetMapping("findProductsThatNeedMoreThenTwoMaterials")
	public List<TermekDarab> findProductsThatNeedMoreThenTwoMaterials() {
		
		return termekService.findProductsThatNeedMoreThenTwoMaterials();
	}
	
	@GetMapping("findProductThatHaveTheMostTypeOfMaterials")
	public List<TermekDarab> findProductThatHaveTheMostTypeOfMaterials() {
		
		return termekService.findProductThatHaveTheMostTypeOfMaterials();
	}

}