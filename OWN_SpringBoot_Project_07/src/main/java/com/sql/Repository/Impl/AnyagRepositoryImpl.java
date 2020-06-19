package com.sql.Repository.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.Repository.AnyagRepository;
import com.sql.model.Anyag;

@Repository
public class AnyagRepositoryImpl implements AnyagRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final RowMapper<Anyag> mapper = new RowMapper<Anyag>() {

		@Override
		public Anyag mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Anyag n = new Anyag();
			n.setAzonosito(rs.getInt("azonosito"));
			n.setNeve(rs.getString("neve"));
			n.setMert_egys(rs.getString("mert_egys"));
			n.setEgys_ar(rs.getDouble("egys_ar"));
			n.setKeszlet(rs.getInt("keszlet"));
			return n;
		}
	};
	
}
