package com.zhi.spring.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SimpleJdbcDaoImpl extends JdbcDaoSupport {
	
	public int getCircleCount(){
		String sql = "select count(*) from user";
		//jdbcTemplate.setDataSource(dataSource);
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
}
