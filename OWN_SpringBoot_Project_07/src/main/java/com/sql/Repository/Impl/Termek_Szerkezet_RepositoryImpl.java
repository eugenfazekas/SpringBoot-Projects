package com.sql.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sql.model.Anyag;
import com.sql.model.AnyagAzonosito;
import com.sql.model.AnyagNev;
import com.sql.repository.Termek_Szerkezet_Repository;

@Repository
public class Termek_Szerkezet_RepositoryImpl implements Termek_Szerkezet_Repository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<AnyagAzonosito> listOfMaterialIDsByProductCode(String material) {
		List<AnyagAzonosito> anyagok = this.jdbcTemplate.query(
				"SELECT nev,azonosito FROM termek,szerkezet WHERE szerkezet.kod = ? AND termek.kod = szerkezet.kod",
				(resultSet, rowNum) -> {
					AnyagAzonosito anyag = new AnyagAzonosito();
					anyag.setAzonosito(resultSet.getInt("azonosito"));
					
				return anyag;
				},material);
		
		return anyagok;
	}

	@Override
	public List<AnyagNev> listOfMaterialNamesByProductName(String material) {
		List<AnyagNev> anyagok = this.jdbcTemplate.query(
				"SELECT nev, neve FROM termek,szerkezet,anyag WHERE termek.kod = szerkezet.kod AND szerkezet.azonosito = anyag.azonosito AND termek.nev = ? ",
				(resultSet, rowNum) -> {
					AnyagNev anyag = new AnyagNev();
					anyag.setTermekNev(resultSet.getString("neve"));
					
				return anyag;
				},material);
		
		return anyagok;
	}



	

}
