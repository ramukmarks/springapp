package com.springapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.dao.EmployeeDao;
import com.springapp.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao; 
	
	@RequestMapping(value="/employee.htm", method = RequestMethod.GET)
	public ModelAndView showEmployes() {
		return new ModelAndView("employee").addObject("employees", employeeDao.getEmployees());
	}
	
	@RequestMapping(value="/addEmployee.htm", method = RequestMethod.GET) 
	public String addEmployeeView() {
		return "addEmployee";
	}
	
	@RequestMapping(value="/addEmployee.htm", method = RequestMethod.POST) 
	public String addEmployee(HttpSession session, Employee employee) {
		employeeDao.addEmployee(employee);
		session.setAttribute("message", "Employee addedd Successfully");
		return "redirect:addEmployee.htm";
	}
	
	@RequestMapping(value="/updateEmployee.htm", method = RequestMethod.GET) 
	public ModelAndView getEmployee(@RequestParam("employeeID") int employeeID) {
		return new ModelAndView("addEmployee").addObject("employee", employeeDao.getEmployee(employeeID));
	}
	
	@RequestMapping(value="/updateEmployee.htm", method = RequestMethod.POST) 
	public ModelAndView updateEmployee(HttpSession session, Employee employee) {
		employeeDao.updateEmployee(employee);
		session.setAttribute("message", "Employee Updated successfully");
		return new ModelAndView("redirect:updateEmployee.htm?employeeID=" + employee.getId());
	}
	
	@RequestMapping(value="/deleteEmployee.htm", method = RequestMethod.POST) 
	public ModelAndView deleteEmployee(HttpSession session, Employee employee) {
		employeeDao.deleteEmployee(employee);
		session.setAttribute("message", "User Deleted successfully");
		return new ModelAndView("redirect:employee.htm");
	}

}
