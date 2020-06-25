package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

	@Override
	public List<Szerkezet> findProductDetails_MaterialsNeededByMaterialId(Integer material) {
		
		String sql = "SELECT  kod, azonosito , mennyiseg  FROM szerkezet WHERE kod IN (SELECT kod FROM szerkezet WHERE azonosito = ? )";
	
		return 	jdbcTemplate.query(sql, mapper,material);
	}
	
}
