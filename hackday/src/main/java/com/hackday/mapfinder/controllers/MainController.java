package com.hackday.mapfinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackday.mapfinder.model.EmployeeModel;
import com.hackday.mapfinder.services.IEmployeeLookup;

@Controller
public class MainController {

	private IEmployeeLookup iEmployeeLookup;

	@Autowired
	public MainController(IEmployeeLookup iEmployeeLookup) {
		this.iEmployeeLookup = iEmployeeLookup;
	}

	@RequestMapping("/")
	public String searchPage(Model model) {

		//model.addAttribute("employeeList", iEmployeeLookup.lookupEmployee("James"));
		return "home";
	}
	
	/*@RequestMapping(value = "/search/{searchTerm}", headers="Accept=application/json")
	public List<EmployeeModel> searchEmployee(Model model, @PathVariable String searchTerm) {
		return iEmployeeLookup.lookupEmployee(searchTerm);
	}*/
	
<<<<<<< HEAD
=======
	@RequestMapping(value = "/employee/{employeeAlias}", method = RequestMethod.GET, headers="Accept=application/json")
	public EmployeeModel loadEmployeeWithAlias(Model model, @PathVariable String employeeAlias) {
		return iEmployeeLookup.getEmployeeByAlias(employeeAlias);

	}
	
	@RequestMapping(value = "/employees/", method = RequestMethod.GET, headers="Accept=application/json")
	public List<EmployeeModel> loadEmployees(Model model) {
		return iEmployeeLookup.getEmployees();

	}
	
	@RequestMapping(value="/search")
	public String startSearch(Model model) {
		return "search";
	}
	
	@RequestMapping(value="/searchResults/employee", method=RequestMethod.GET, params="employee")
	public String getEmployee(@RequestParam("employee") String employee) {
	    System.out.println(employee);
	    return "SearchResults";
	}
>>>>>>> origin/master
}
