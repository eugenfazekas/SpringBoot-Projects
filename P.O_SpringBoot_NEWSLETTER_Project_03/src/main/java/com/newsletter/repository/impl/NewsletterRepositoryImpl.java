package com.newsletter.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.newsletter.entity.Newsletter;
import com.newsletter.repository.NewsletterRepository;

@Repository
public class NewsletterRepositoryImpl implements NewsletterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final RowMapper<Newsletter> mapper = new RowMapper<Newsletter>() {

		@Override
		public Newsletter mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Newsletter n = new Newsletter();
			n.setContent(rs.getString("content"));
			n.setSubject(rs.getString("subject"));
			return n;
		}
	};
		
	@Override
	public @NotNull List<Newsletter> getNewsLettersForPeriodOrderedByDescendingPublishingDateLimitedByMaxRecordCount(
			@NotNull LocalDate fromDate, @NotNull LocalDate toDate, @Min(1) @Max(10) int maxRecords) {
		
		final String sql =  "Select subject, content FROM newsletters WHERE "
				+ " publishingdate >= ? AND publishingdate <= ? ORDER BY "
				+ "publishingdate DESC LIMIT ?";
		
		
		
			return jdbcTemplate.query(sql, mapper,fromDate,toDate,maxRecords);
	}
}

//	@Override
//	public @NotNull List<Newsletter> getNewsLettersForPeriodOrderedByDescendingPublishingDateLimitedByMaxRecordCount(
//			@NotNull LocalDate fromDate, @NotNull LocalDate toDate, @Min(1) @Max(10) int maxRecords) {
//		
//		final String sql =  "Select subject, content FROM newsletters WHERE "
//				+ " publishingdate >= ? AND publishingdate <= ? OREDER BY "
//				+ "publishingdate DESC LIMIT ?";
//		
//		final RowMapper<Newsletter> mapper = new BeanPropertyRowMapper<>(Newsletter.class);
//		
//			return jdbcTemplate.query(sql, mapper,fromDate,toDate,maxRecords);
	
	

		
	



