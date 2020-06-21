package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
}
