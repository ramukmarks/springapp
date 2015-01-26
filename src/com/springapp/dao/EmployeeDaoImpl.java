package com.springapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springapp.model.Employee;

@Repository 
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public Collection<Employee> getEmployees() {
		List<Employee> employees = jdbcTemplateObject.query("select * from employee_details", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setCompany(rs.getString("company"));
				employee.setDepartment(rs.getString("department"));
				return employee;
			}
			
		});
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee = jdbcTemplateObject.queryForObject("select * from employee_details where id=?", new Object[]{id}, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setCompany(rs.getString("company"));
				employee.setDepartment(rs.getString("department"));
				return employee;
			}
			
		});
		
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		jdbcTemplateObject.update("INSERT into employee_details(name,company,department) values(?,?,?)", employee.getName(), employee.getCompany(), employee.getDepartment());
	}

	@Override
	public void updateEmployee(Employee employee) {
		jdbcTemplateObject.update("update employee_details SET name=?, company=?,department=? where id=?", employee.getName(), employee.getCompany(), employee.getDepartment(), employee.getId());
	}

	@Override
	public void deleteEmployee(Employee employee) {
		jdbcTemplateObject.update("DELETE from employee_details where id=?", employee.getId());
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		System.out.println("EmployeeDaoImpl.setDataSource(): " + Calendar.getInstance().getTime()); 
		System.out.println(dataSource);
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
