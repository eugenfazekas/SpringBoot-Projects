package com.sql.Repository.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.Repository.RendelesRepository;
import com.sql.model.Rendeles;

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
	
}
