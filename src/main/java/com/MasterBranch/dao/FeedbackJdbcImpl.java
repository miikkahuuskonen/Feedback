package com.MasterBranch.dao;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.MasterBranch.bean.Query;
/**
 * 
 * 
 *
 */

public class FeedbackJdbcImpl {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Query> getAllQueries(int inqueryId){
		String sql = "SELECT queries FROM inquires WHERE id = ?";
		Object[] parameter = new Object[] { inqueryId };
		RowMapper<Query> queryMapper = new FeedbackQueryRowMapper();
		List<Query> queries = null;
		try {
			queries = jdbcTemplate.query(sql, parameter, queryMapper);
		}catch(IncorrectResultSizeDataAccessException e){
			System.out.println("Cannot find data from database");
		}
		return queries;
	}
	
}
