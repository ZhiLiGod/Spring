package com.zhi.spring.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.PreparedStatement;
import com.zhi.spring.pojo.NewCircle;

@Component
public class JdbcDaoImpl  {
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int getCircleCount(){
		String sql = "select count(*) from user";
		//jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public NewCircle getCircleById(int id){
		String sql = "select * from user where id = ?";
		return jdbcTemplate.queryForObject(sql, 
				new Object[] {id}, 
				new CircleMapper());
		
	}
	
//	public void insertCircle(NewCircle circle){
//		String sql = "insert into user(id, username) values(?,?)";
//		jdbcTemplate.update(sql, new Object[] {circle.getId(),
//				circle.getName()});
//	}
	public void insertCircle(NewCircle circle){
		String sql = "insert into user(id, username) values(:id,:name)";
		SqlParameterSource namedParameters = 
				new MapSqlParameterSource("id", circle.getId()).addValue("username", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	private static final class CircleMapper implements RowMapper<NewCircle>{

		@Override
		public NewCircle mapRow(ResultSet rs, int rowNum) throws SQLException {
			NewCircle circle = new NewCircle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("username"));
			return circle;
		}
		
	}
	
	public NewCircle getCircle(int circleId) throws Exception{
		Connection conn = null;
		conn = dataSource.getConnection();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from user where id=?");
		ps.setInt(1, circleId);
		
		NewCircle circle = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			circle = new NewCircle(circleId, rs.getString("username"));
		}
		rs.close();
		ps.close();
		conn.close();
		return circle;
	}
}
