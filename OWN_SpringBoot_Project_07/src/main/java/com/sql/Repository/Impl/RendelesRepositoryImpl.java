package com.sql.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.model.AnyagRendeleshez;
import com.sql.model.Rend_Honap;
import com.sql.model.Rendeles;
import com.sql.model.RendelesCheck;
import com.sql.model.RendelesNev;
import com.sql.model.TermekDarab;
import com.sql.model.TermekNev_AnyagAzonosito;
import com.sql.repository.RendelesRepository;

@Repository
public class RendelesRepositoryImpl implements RendelesRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final RowMapper<Rendeles> mapper = new RowMapper<Rendeles>() {

		@Override
		public Rendeles mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Rendeles n = new Rendeles();
			n.setRend_szam(rs.getString("rend_szam"));
			n.setKod(rs.getString("kod"));
			n.setDarab(rs.getInt("darab"));
			n.setDate(rs.getDate("datum"));
			n.setKesz(rs.getBoolean("kesz"));
			return n;
		}
	};

	@Override
	public List<Rendeles> findOrderByCharByDate(char character, String date1, String date2) {
	
	List<Rendeles> search = null;
	String sql = "  SELECT * FROM rendeles WHERE ( datum = ?  OR datum = ?  ) AND Left(kod,1) = ? ";

	try {
	  search = jdbcTemplate.query(sql, mapper,date1,date2,character);
	}catch (Exception e)   {System.out.println(e);}
	
	return search;
	}

	@Override
	public List<Rendeles> findProductsUntilDeadline(String datedealine) {

		Date date = new Date();
		String sql = "SELECT * FROM rendeles where kesz = false AND datum BETWEEN ? AND ? ";
		return jdbcTemplate.query(sql, mapper,date,datedealine);
	}

	@Override
	public Integer totalPiecesRemainUndelivered() {
		String sql = "SELECT SUM(darab) FROM rendeles WHERE kesz = false";
		
		Integer pieces = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		return pieces;
	}

	@Override
	public List<RendelesNev> findOrderByTwoProductsFromOrder(String product1, String product2) {
		
		// SELECT rend_szam  from rendeles where kod = ? or kod = ? group by rend_szam having count(*) = 2;
		String  sql = "SELECT rend_szam from rendeles where kod = ? AND rend_szam IN (SELECT rend_szam FROM rendeles WHERE kod = ? )" ; 
		
		List<RendelesNev> rendelesek = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			RendelesNev rendelesNev = new RendelesNev();
			rendelesNev.setRendelesNev(resultSet.getString("rend_szam"));
				return rendelesNev;
		},product1,product2);
		
		return rendelesek;
	}
	
	@Override
	public List<RendelesCheck> findTotalPriceOfAnOrderByDate(String date1, String date2) {
		List<RendelesCheck> termekek = this.jdbcTemplate.query(
				"SELECT rendelesfej.rend_szam, SUM(rendeles.darab * termek.ar) AS ertek, MAX(rendelesfej.rend_datum) AS honap FROM rendelesfej, rendeles, termek "
				+ " WHERE rendelesfej.rend_szam = rendeles.rend_szam "
				+ " AND rendeles.kod = termek.kod and rendelesfej.rend_datum between ? AND ? GROUP BY rendelesfej.rend_szam ",
				(resultSet, rowNum) -> {
					RendelesCheck rendeles = new RendelesCheck();
					rendeles.setKod(resultSet.getString("rend_szam"));
					rendeles.setDate(resultSet.getString("honap"));
					rendeles.setPrice(resultSet.getInt("ertek"));
				return rendeles;
				},date1,date2);
		
		return termekek;
	}
	
	@Override
	public List<RendelesCheck> findTotalPriceForAllOrders() {
		List<RendelesCheck> termekek = this.jdbcTemplate.query(
				"SELECT rendelesfej.rend_szam, SUM(rendeles.darab * termek.ar) AS ertek, rendelesfej.rend_datum AS honap FROM rendelesfej, rendeles, termek "
				+ "WHERE rendelesfej.rend_szam = rendeles.rend_szam and rendeles.kod = termek.kod GROUP BY rendelesfej.rend_szam ",
				(resultSet, rowNum) -> {
					RendelesCheck rendeles = new RendelesCheck();
					rendeles.setKod(resultSet.getString("rend_szam"));
					rendeles.setDate(resultSet.getString("honap"));
					rendeles.setPrice(resultSet.getInt("ertek"));
				return rendeles;
				});
		
		return termekek;
	}

	@Override
	public int[] bacthUpdateForREND_HONAP_Table() throws SQLException {

		List<RendelesCheck> rendelesek = findTotalPriceForAllOrders();
		return this.jdbcTemplate.batchUpdate(
		"INSERT INTO REND_HONAP (rend_szam,ertek,honap) VALUES ( ? , ? , ? ) ",
		new BatchPreparedStatementSetter() {
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			RendelesCheck rendeles = rendelesek.get(i);
		ps.setString(1, rendeles.getKod());
		ps.setInt(2, rendeles.getPrice());
		ps.setString(3, rendeles.getDate());
		}
		public int getBatchSize() {
			return rendelesek.size(); 
		}
	});
	}

	@Override
	public List<Rend_Honap> findHighestValueOrder() {
		List<Rend_Honap> rendelesek = this.jdbcTemplate.query(
				"SELECT rend_szam , ertek ,honap FROM rend_honap WHERE ertek = (SELECT MAX(ertek) FROM rend_honap) ORDER BY rend_szam",
				(resultSet, rowNum) -> {
					Rend_Honap rendeles = new Rend_Honap();
					rendeles.setRend_szam(resultSet.getString("rend_szam"));
					rendeles.setErtek(resultSet.getInt("ertek"));
					rendeles.setHonap(resultSet.getString("honap"));
				return rendeles;
				});
		
		return rendelesek;
	}

	@Override
	public List<AnyagRendeleshez> findMaterialsNeededInDate(String date) {
		List<AnyagRendeleshez> anyagokRendeleshez = jdbcTemplate.query(
				"SELECT anyag.azonosito, MAX(anyag.neve) AS Anyagnev, SUM(rendeles.darab * szerkezet.mennyiseg) AS Osszes_Anyag , MIN(anyag.mert_egys) AS Mertekegyseg "
				+ "FROM rendeles, szerkezet, anyag WHERE rendeles.kod = szerkezet.kod AND szerkezet.azonosito = anyag.azonosito "
				+ "AND rendeles.datum = ? GROUP BY anyag.azonosito",
				(resultSet,rowNum) -> {
					AnyagRendeleshez anyag = new AnyagRendeleshez();
					anyag.setAzonosito(resultSet.getInt("azonosito"));
					anyag.setAnyagnev(resultSet.getString("anyagnev"));
					anyag.setOsszes_anyag(resultSet.getInt("osszes_anyag"));
					anyag.setMertekegyseg(resultSet.getString("mertekegyseg"));
					return anyag;
				},date );
		return anyagokRendeleshez;
	}
}
