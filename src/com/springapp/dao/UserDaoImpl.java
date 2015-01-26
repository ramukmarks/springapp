package com.springapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.springapp.security.User;
import com.springapp.security.model.Role;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = jdbcTemplateObject.queryForObject("select * from user where username=?", new Object[]{username},  new RowMapper<User>() {
				
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(user.getUsername());
				user.setLastName(user.getLastName());
				Role r = new Role();
		        r.setName("ROLE_USER");
		        List<Role> roles = new ArrayList<Role>();
		        roles.add(r);
		        user.setAuthorities(roles);
				return user;
			}
			
		});
		
		if(username.equalsIgnoreCase(user.getUsername())) {
			return user;
		} 
		
		throw new UsernameNotFoundException("Invalid user credentials");
	}


	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}


	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}
