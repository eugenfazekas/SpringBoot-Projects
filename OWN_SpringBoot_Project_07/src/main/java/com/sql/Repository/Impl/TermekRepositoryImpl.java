package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.model.AnyagNev;
import com.sql.model.Termek;
import com.sql.model.TermekNev;
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
	
}
