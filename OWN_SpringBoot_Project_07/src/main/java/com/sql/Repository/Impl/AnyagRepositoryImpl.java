package com.sql.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sql.model.Anyag;
import com.sql.repository.AnyagRepository;

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

	@Override
	public List<Anyag> findMaterialBetweenCode(String code1, String code2) {
		
		String sql = "SELECT * FROM anyag WHERE ? <= azonosito AND azonosito <= ? ";
		
		return jdbcTemplate.query(sql,mapper,code1,code2);
	}
	
	@Override
	public List<Anyag> findMaterialByUnit(String unit) {
		
		String sql = "SELECT * FROM anyag WHERE mert_egys = ? ";
		
		return jdbcTemplate.query(sql,mapper,unit);
	}
	
	@Override
	public List<Anyag> findMaterialByUnitsCmOrM(String unit1, String unit2) {
		
		String sql = "SELECT * FROM anyag WHERE mert_egys IN (?,?) ";
		
		return jdbcTemplate.query(sql,mapper,unit1,unit2);
	}

	@Override
	public Integer countMaterialWhereStorageSmallerThen(String number) {
		
		final String  sql = "Select count(*)  from anyag where keszlet < ? ;";
		int count = jdbcTemplate.queryForObject(sql, new Object[] {number}, Integer.class); 
		
		return count;
	}

	@Override
	public List<Anyag> findMaterialWithLikeOpeator(String neve) {
		
		String neveIn = "%"+neve+"%"; 
		String sql = "SELECT * FROM anyag WHERE neve LIKE ? ";
		return jdbcTemplate.query(sql,mapper,neveIn);
	}
	
}
