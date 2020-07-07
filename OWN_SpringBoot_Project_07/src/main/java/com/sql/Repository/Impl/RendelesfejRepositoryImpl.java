package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.model.Partner;
import com.sql.model.RendelesByDateAndName;
import com.sql.model.RendelesByGreatherThen;
import com.sql.model.RendelesFejTermekLista;
import com.sql.model.Rendelesfej;
import com.sql.repository.RendelesfejRepository;

@Repository
public class RendelesfejRepositoryImpl implements RendelesfejRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final RowMapper<Rendelesfej> mapper = new RowMapper<Rendelesfej>() {

		@Override
		public Rendelesfej mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Rendelesfej n = new Rendelesfej();
			n.setRend_szam(rs.getString("rend_szam"));
			n.setPartner_kod(rs.getString("partner_kod"));
			n.setDate(rs.getDate("rend_datum"));
			return n;
		}
	};

	@Override
	public List<RendelesFejTermekLista> countProductsOrderdByCustomers() {
	
		List<RendelesFejTermekLista> termekek = jdbcTemplate.query(
		"SELECT partner_kod, kod, SUM(darab) FROM rendelesfej,rendeles WHERE rendelesfej.rend_szam = rendeles.rend_szam GROUP BY partner_kod, kod",
		(resultSet,rowNum) -> {
			RendelesFejTermekLista termek = new RendelesFejTermekLista();
			termek.setPartner_kod(resultSet.getInt("partner_kod"));
			termek.setKod(resultSet.getString("kod"));
			termek.setDarab(resultSet.getInt("SUM(darab)"));
			return termek;
		});
		return termekek;
	}

	@Override
	public List<RendelesByDateAndName> findOrderByNameAndDate(Integer partnerkod, String date1, String date2) {
		String partnerkodIn = "%"+partnerkod+"%";
		List<RendelesByDateAndName> rendelesek = jdbcTemplate.query(
				"SELECT partner_kod, kod, SUM(darab),rend_datum FROM rendelesfej, rendeles WHERE rendelesfej.rend_szam = rendeles.rend_szam"
				+ " AND rend_datum BETWEEN ? AND ? AND partner_kod LIKE ? GROUP BY partner_kod,kod",
				(resultSet,rowNum) -> {
					RendelesByDateAndName rendeles = new RendelesByDateAndName();
					rendeles.setPartnerkod(resultSet.getInt("partner_kod"));
					rendeles.setKod(resultSet.getString("kod"));
					rendeles.setDarab(resultSet.getInt("SUM(DARAB)"));
					rendeles.setDatum(resultSet.getString("rend_datum"));
				return rendeles;
				},date1,date2,partnerkodIn
				);
				
		return rendelesek;
	}

	@Override
	public List<RendelesByGreatherThen> findOrderThatOneTypeProductQTYIsGreatherThanX(String date1, String date2,String productcode, Integer qty) {
		String productcodeIn = "%"+productcode+"%";
		List<RendelesByGreatherThen> rendelesek = jdbcTemplate.query(
				"SELECT partner_kod ,rendelesfej.rend_szam,kod , SUM(darab) FROM rendelesfej, rendeles WHERE rendelesfej.rend_szam = rendeles.rend_szam "
				+ "AND rend_datum BETWEEN ? AND ? AND kod LIKE ? GROUP BY partner_kod,kod,rendelesfej.rend_szam HAVING SUM(darab) >  ? ",
				(resultSet,rowNum) -> {
					RendelesByGreatherThen rendeles = new RendelesByGreatherThen();
					rendeles.setPartnerkod(resultSet.getInt("partner_kod"));
					rendeles.setRend_szam(resultSet.getString("rend_szam"));
					rendeles.setKod(resultSet.getString("kod"));
					rendeles.setDarab(resultSet.getInt("SUM(darab)"));
					return rendeles;
				},date1,date2,productcodeIn,qty);
		return rendelesek;
	}

	@Override
	public List<Partner> findCustomersThatHaveAllOrdersABoveXValue(Integer targetvalue) {
		List<Partner> partnerek = jdbcTemplate.query(
				"SELECT partner_kod from partner WHERE ? < ALL (SELECT SUM(darab*ar) FROM rendelesfej,rendeles,termek WHERE rendelesfej.partner_kod = partner.partner_kod "
				+ "AND rendelesfej.rend_szam = rendeles.rend_szam AND rendeles.kod = termek.kod GROUP BY rendelesfej.rend_szam)",
				(resultSet,rowNum) -> {
					Partner partner = new Partner();
					partner.setPartner(resultSet.getInt("partner_kod"));
					return partner;
				},targetvalue
				);
		return partnerek;
	}

	@Override
	public List<Partner> findCustomersThatHaveOrdersBeloveXValue(Integer targetvalue) {
		List<Partner> partnerek = jdbcTemplate.query(
				"SELECT partner_kod from partner WHERE EXISTS (SELECT SUM(darab*ar) FROM rendelesfej,rendeles,termek WHERE rendelesfej.partner_kod = partner.partner_kod "
				+ "AND rendelesfej.rend_szam = rendeles.rend_szam AND rendeles.kod = termek.kod GROUP BY rendelesfej.rend_szam HAVING SUM(darab*ar) <= ?)",
				(resultSet,rowNum) -> {
					Partner partner = new Partner();
					partner.setPartner(resultSet.getInt("partner_kod"));
					return partner;
				},targetvalue
				);
		return partnerek;
	}
}
