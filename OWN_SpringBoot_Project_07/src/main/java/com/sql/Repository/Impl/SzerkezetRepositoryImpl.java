package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.model.Szerkezet;
import com.sql.repository.SzerkezetRepository;

@Repository
public class SzerkezetRepositoryImpl implements SzerkezetRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final RowMapper<Szerkezet> mapper = new RowMapper<Szerkezet>() {

		@Override
		public Szerkezet mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Szerkezet n = new Szerkezet();
			n.setKod(rs.getString("kod"));
			n.setAzonosito(rs.getInt("azonosito"));
			n.setMennyiseg(rs.getInt("mennyiseg"));
			return n;
		}
	};
	
}
