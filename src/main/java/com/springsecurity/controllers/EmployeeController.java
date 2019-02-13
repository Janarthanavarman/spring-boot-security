package com.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import  com.springsecurity.model.Employee;
import  com.springsecurity.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", new Employee());
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {
		
		employeeService.insertEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
	
		return "about";
	}
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
	
		return "contact";
	}
	@RequestMapping(value = "/viewMenu", method = RequestMethod.GET)
	public String viewMenu(Model model) {
	
		return "viewMenu";
	}
	@RequestMapping(value = "/admin/employeeManagement", method = RequestMethod.GET)
	public String employeeManagement(Model model) {
	
		return "admin/employeeManagement";
	}
	@RequestMapping(value = "/admin/menuManagement", method = RequestMethod.GET)
	public String menuManagement(Model model) {
	
		return "admin/menuManagement";
	}
	@RequestMapping(value = "/admin/reportManagement", method = RequestMethod.GET)
	public String reportManagement(Model model) {
	
		return "admin/reportManagement";
	}
}
