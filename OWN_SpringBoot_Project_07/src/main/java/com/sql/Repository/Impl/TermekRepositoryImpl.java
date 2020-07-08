package com.sql.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.sql.model.RendelesCheck;
import com.sql.model.Termek;
import com.sql.model.TermekAr;
import com.sql.model.TermekBonyolultsag;
import com.sql.model.TermekDarab;
import com.sql.model.TermekGyarthato;
import com.sql.model.TermekNev;
import com.sql.model.TermekNev_AnyagAzonosito;
import com.sql.model.TermekVelemeny;
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

	@Override
	public List<TermekGyarthato> listProductsThatCanBeManufacturedOrNot() {
		List<TermekGyarthato> termekek = jdbcTemplate.query(
				"SELECT termek.kod,nev, 'legyarthato' AS Gyarthat FROM termek WHERE 0 <= ALL (SELECT keszlet - mennyiseg "
				+ "FROM szerkezet,anyag WHERE szerkezet.azonosito = anyag.azonosito AND szerkezet.kod = termek.kod) UNION "
				+ "SELECT termek.kod,nev, 'nem legyarthato le' AS Gyarthat FROM termek WHERE 0 > ANY (SELECT keszlet - mennyiseg "
				+ "FROM szerkezet, anyag WHERE szerkezet.azonosito = anyag.azonosito AND szerkezet.kod = termek.kod) ORDER BY nev;",
				(resultSet,rowNum) -> {
					TermekGyarthato termek = new TermekGyarthato();
					termek.setKod(resultSet.getString("kod"));
					termek.setNev(resultSet.getString("nev"));
					termek.setGyarthat(resultSet.getString("gyarthat"));
					return termek;
				});
		return termekek;
	}

	@Override
	public List<TermekAr> listProductsPrice() {
		List<TermekAr> termekarak = jdbcTemplate.query(
				"SELECT kod , SUM(mennyiseg * egys_ar) AS aar FROM szerkezet, anyag WHERE szerkezet.azonosito = anyag.azonosito GROUP BY kod",
				(resultSet,rowNum) -> {
					TermekAr termekar = new TermekAr();
					termekar.setKod(resultSet.getString("kod"));
					termekar.setAr(resultSet.getInt("aar"));
					return termekar;
				}
				);
		return termekarak;
	}
	
	@Override
	public int[] bacthUpdateProductsPrice() {
		List<TermekAr> termekarak = listProductsPrice();
			return this.jdbcTemplate.batchUpdate(
				"INSERT INTO TERMEKARAK (kod, aar) VALUES ( ? , ? ) ",
				new BatchPreparedStatementSetter() {
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					TermekAr termekAr = termekarak.get(i);
				ps.setString(1, termekAr.getKod());
				ps.setInt(2, termekAr.getAr());
				}
				public int getBatchSize() {
					return termekarak.size(); 
				}
			});
			}

	@Override
	public List<TermekVelemeny> productsPriceOpinion() {
		
		List<TermekVelemeny> termekvelemenyek = jdbcTemplate.query(
				"SELECT kod, szoveg FROM termekarak, minosit kulso WHERE aar >= kulso.also "
				+ "AND kulso.also = (SELECT MAX(belso.also) FROM minosit belso WHERE aar >= belso.also)",
				(resultSet,rowNum) -> {
					TermekVelemeny termekvelemeny = new TermekVelemeny();
					termekvelemeny.setKod(resultSet.getString("kod"));
					termekvelemeny.setSzoveg(resultSet.getString("szoveg"));
					return termekvelemeny;
				}
				);
		
		return termekvelemenyek;
	}

	@Override
	public List<TermekBonyolultsag> listProductsComplexityWithAutoGeneratedIDs() {
		 List<TermekBonyolultsag> termeklista = jdbcTemplate.query(
				 "SELECT COUNT(elso.kod) AS sorszam, elso.kod, elso.bonyolultsag FROM termek_b elso, termek_b masodik WHERE elso.bonyolultsag > masodik.bonyolultsag"
				 + " OR (elso.bonyolultsag =  masodik.bonyolultsag AND elso.kod  >= masodik.kod ) GROUP BY elso.kod , elso.bonyolultsag ORDER BY 1",
				 (resultSet,rowNum) -> {
					 TermekBonyolultsag termek = new TermekBonyolultsag();
					 termek.setId(resultSet.getInt("sorszam"));
					 termek.setKod(resultSet.getString("kod"));
					 termek.setBonyolultsag(resultSet.getInt("bonyolultsag"));
					 return termek;
				 }
				 );
		return termeklista;
	}

}
