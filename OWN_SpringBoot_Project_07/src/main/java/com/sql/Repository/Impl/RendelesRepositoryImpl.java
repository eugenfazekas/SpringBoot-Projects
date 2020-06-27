package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.model.Rendeles;
import com.sql.model.RendelesNev;
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
	
}
