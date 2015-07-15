package com.hackday.mapfinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackday.mapfinder.model.EmployeeModel;
import com.hackday.mapfinder.services.IEmployeeLookup;

@RestController
public class MainController {

	private IEmployeeLookup iEmployeeLookup;

	@Autowired
	public MainController(IEmployeeLookup iEmployeeLookup) {
		this.iEmployeeLookup = iEmployeeLookup;
	}

	@RequestMapping("/")
	public String searchPage(Model model) {

		model.addAttribute("employeeList", iEmployeeLookup.lookupEmployee("James"));
		return "home";
	}
	
	@RequestMapping(value = "/search/{searchTerm}", headers="Accept=application/json")
	public List<EmployeeModel> searchEmployee(Model model, @PathVariable String searchTerm) {
		return iEmployeeLookup.lookupEmployee(searchTerm);
	}
	
	@RequestMapping(value = "/employee/{employeeAlias}", method = RequestMethod.GET, headers="Accept=application/json")
	public EmployeeModel loadEmployeeWithAlias(Model model, @PathVariable String employeeAlias) {
		return iEmployeeLookup.getEmployeeByAlias(employeeAlias);

	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET, headers="Accept=application/json")
	public List<EmployeeModel> loadEmployees(Model model) {
		return iEmployeeLookup.getEmployees();

	}
	
	@RequestMapping(value = "/directReports/{alias}", method = RequestMethod.GET, headers="Accept=application/json")
	public List<EmployeeModel> getDirectReports(Model model, @ PathVariable String alias) {
		return iEmployeeLookup.getDirectReports(alias);

	}
}
