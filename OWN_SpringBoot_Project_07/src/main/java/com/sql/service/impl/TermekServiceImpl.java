package com.sql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;
import com.sql.model.Termek;
import com.sql.model.TermekDarab;
import com.sql.model.TermekGyarthato;
import com.sql.model.TermekNev;
import com.sql.model.TermekNev_AnyagAzonosito;
import com.sql.model.TermekVelemeny;
import com.sql.repository.TermekRepository;
import com.sql.repository.Termek_Szerkezet_Repository;
import com.sql.service.TermekService;

@Service
public class TermekServiceImpl implements TermekService {

	private TermekRepository termekRepository;
	private Termek_Szerkezet_Repository termek_Szerkezet_Repository ;

	@Override
	public Integer averagePriceOfProducts() {
		
		return termekRepository.averagePriceOfProducts();
	}

	public TermekServiceImpl(TermekRepository termekRepository, Termek_Szerkezet_Repository termek_Szerkezet_Repository) {
		this.termekRepository = termekRepository;
		this.termek_Szerkezet_Repository = termek_Szerkezet_Repository;
	}

	@Override
	public List<AnyagAzonosito> listOfMaterialIDsByProductCode(String material) {
		
		return termek_Szerkezet_Repository.listOfMaterialIDsByProductCode(material);
	}

	@Override
	public List<AnyagNev> listOfMaterialNamesByProductName(String material) {
		
		return termek_Szerkezet_Repository.listOfMaterialNamesByProductName(material);
	}

	@Override
	public List<TermekNev> findProductsByWhatContainsMaterialID(Integer maerialId) {
		
		return termekRepository.findProductsByWhatContainsMaterialID(maerialId);
	}

	@Override
	public List<TermekNev_AnyagAzonosito> findProductsWithMaterialsListByOneMaterialID(Integer materialID) {
		
		return termek_Szerkezet_Repository.findProductsWithMaterialsListByOneMaterialID(materialID);
	}

	@Override
	public List<Termek> findProductsWhatCanBeOrderdButNotOrderedYet() {
		
		return termekRepository.findProductsWhatCanBeOrderdButNotOrderedYet();
	}

	@Override
	public List<TermekDarab> findProductsWhatWasOrderAndHerQuatityAndCanBeOrdered() {
		
		return termekRepository.findProductsWhatWasOrderAndHerQuatityAndCanBeOrdered();
	}

	@Override
	public List<TermekDarab> countMaterialsForAProduct() {
		
		return termekRepository.countMaterialsForAProduct();
	}

	@Override
	public List<TermekDarab> findProductsThatNeedMoreThenTwoMaterials() {
		
		return termekRepository.findProductsThatNeedMoreThenTwoMaterials();
	}

	@Override
	public List<TermekDarab> findProductThatHaveTheMostTypeOfMaterials() {
		
		return termekRepository.findProductThatHaveTheMostTypeOfMaterials();
	}

	@Override
	public List<TermekNev> findProductsThatDontHavaMaterialListDescription() {
		
		return termekRepository.findProductsThatDontHavaMaterialListDescription();
	}

	@Override
	public List<TermekGyarthato> listProductsThatCanBeManufacturedOrNot() {
		
		return termekRepository.listProductsThatCanBeManufacturedOrNot();
	}

	@Override
	public List<TermekVelemeny> productsPriceOpinion() {
		try {
		termekRepository.bacthUpdateProductsPrice();
		} catch (Exception e){ System.out.println("Products price already inserted");}
		return termekRepository.productsPriceOpinion();
	}

}
