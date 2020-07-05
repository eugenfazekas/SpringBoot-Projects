package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.model.Termek;
import com.sql.model.TermekDarab;
import com.sql.model.TermekNev;
import com.sql.model.TermekNev_AnyagAzonosito;
import com.sql.repository.TermekRepository;

@Repository
public class TermekRepositoryImpl implements TermekRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final RowMapper<Termek> mapper = new RowMapper<Termek>() {

		@Override
		public Termek mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Termek n = new Termek();
			n.setKod(rs.getString("kod"));
			n.setNev(rs.getString("nev"));
			n.setAr(rs.getInt("ar"));
			return n;
		}
	};

	@Override
	public Integer averagePriceOfProducts() {
		
		String sql = "SELECT AVG(ar) FROM termek";
		Integer avgPrice = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		
		return avgPrice;
	}

	@Override
	public List<TermekNev> findProductsByWhatContainsMaterialID(Integer maerialId) {

		List<TermekNev> termeknevek = this.jdbcTemplate.query(
				"SELECT nev FROM termek WHERE kod in (SELECT kod FROM szerkezet WHERE azonosito = ? )",
				(resultSet, rowNum) -> {
					TermekNev termek = new TermekNev();
					termek.setTermekNev(resultSet.getString("nev"));
					
				return termek;
				},maerialId);
		
		return termeknevek;
	}

	@Override
	public List<Termek> findProductsWhatCanBeOrderdButNotOrderedYet() {
		String sql ="SELECT * FROM termek WHERE kod NOT IN (SELECT kod FROM rendeles)";
	
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<TermekDarab> findProductsWhatWasOrderAndHerQuatityAndCanBeOrdered() {
		List<TermekDarab> termekek = this.jdbcTemplate.query(
				"SELECT termek.kod, nev,  SUM(darab) FROM termek, rendeles WHERE termek.kod = rendeles.kod GROUP BY termek.kod,nev",
				(resultSet, rowNum) -> {
					TermekDarab termek = new TermekDarab();
					termek.setKod(resultSet.getString("kod"));
					termek.setNev(resultSet.getString("nev"));
					termek.setDarab(resultSet.getInt("SUM(DARAB)"));
				return termek;
				});
		
		return termekek;
	}

	@Override
	public List<TermekDarab> countMaterialsForAProduct() {
		List<TermekDarab> termekek = this.jdbcTemplate.query(
				"SELECT termek.kod , termek.nev, (SELECT COUNT(*) FROM szerkezet WHERE szerkezet.kod = termek.kod) AS db FROM termek",
				(resultSet, rowNum) -> {
					TermekDarab termek = new TermekDarab();
					termek.setKod(resultSet.getString("kod"));
					termek.setNev(resultSet.getString("nev"));
					termek.setDarab(resultSet.getInt("DB"));
				return termek;
				});
		
		return termekek;
	}
	

	@Override
	public List<TermekDarab> findProductsThatNeedMoreThenTwoMaterials() {
		List<TermekDarab> termekek = this.jdbcTemplate.query(
				"SELECT kod,  COUNT(*) AS db FROM szerkezet GROUP BY kod HAVING COUNT(*) >= 3",
				(resultSet, rowNum) -> {
					TermekDarab termek = new TermekDarab();
					termek.setKod(resultSet.getString("kod"));
					termek.setDarab(resultSet.getInt("DB"));
				return termek;
				});
		
		return termekek;
	}

	@Override
	public List<TermekDarab> findProductThatHaveTheMostTypeOfMaterials() {
		List<TermekDarab> termekek = this.jdbcTemplate.query(
				"SELECT kod, db FROM (SELECT kod , COUNT(*) AS db from szerkezet GROUP BY kod) WHERE db = (SELECT MAX(db) FROM (SELECT COUNT(*) AS db FROM szerkezet GROUP BY kod ))",
				(resultSet, rowNum) -> {
					TermekDarab termek = new TermekDarab();
					termek.setKod(resultSet.getString("kod"));
					termek.setDarab(resultSet.getInt("DB"));
				return termek;
				});
		
		return termekek;
	}

	@Override
	public List<TermekNev> findProductsThatDontHavaMaterialListDescription() {
		List<TermekNev> termekek = this.jdbcTemplate.query(
				"SELECT kod AS nincs_szerkezete FROM termek WHERE kod NOT IN (SELECT kod FROM szerkezet)",
				(resultSet, rowNum) -> {
					TermekNev termek = new TermekNev();
					termek.setTermekNev(resultSet.getString("nincs_szerkezete"));
					return termek;
				});
		
		return termekek;
	}

}
