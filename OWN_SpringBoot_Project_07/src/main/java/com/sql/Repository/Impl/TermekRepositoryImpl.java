package com.sql.Repository.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.sql.Repository.TermekRepository;
import com.sql.model.Termek;

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
	
}
