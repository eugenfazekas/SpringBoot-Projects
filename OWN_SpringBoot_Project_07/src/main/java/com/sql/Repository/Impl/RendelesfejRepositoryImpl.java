package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
}
