package com.springapp.dao;

import java.util.Collection;

import com.springapp.model.Employee;

public interface EmployeeDao {
	
	void addEmployee(Employee employee);
	
	Collection<Employee> getEmployees();
	
	Employee getEmployee(int id);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);

}
