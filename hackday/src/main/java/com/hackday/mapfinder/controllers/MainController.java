package com.hackday.mapfinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hackday.mapfinder.model.EmployeeModel;
import com.hackday.mapfinder.services.IEmployeeLookup;

@Controller
public class MainController {

	private IEmployeeLookup iEmployeeLookup;

	@Autowired
	public MainController(IEmployeeLookup iEmployeeLookup) {
		this.iEmployeeLookup = iEmployeeLookup;
	}

	/*@RequestMapping("/")
	public String searchPage(Model model) {

		//model.addAttribute("employeeList", iEmployeeLookup.lookupEmployee("James"));
		return "home";
	}*/

    
    @RequestMapping(value="/")
    public String startSearch(Model model) {
        return "search";
    }
    
    @RequestMapping(value="/searchResults/employee", method=RequestMethod.GET, params="employee")
    public String getEmployee(@RequestParam("employee") String employee, Model model) {
        System.out.println(employee);
        List<EmployeeModel> employeeList = iEmployeeLookup.lookupEmployee(employee);
        for(int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i).getFirstName());
        }
        model.addAttribute("employeeList", employeeList);
        return "searchResults";
    }
    
    @RequestMapping(value= "/orgChart/{alias}", headers="Accept=application/json")
	public String orgChart(Model model, @PathVariable String alias) {
    	if(iEmployeeLookup.getDirectReports(alias).size() < 1) {
    		String newAlias = iEmployeeLookup.getEmployeeSupervisorByAlias(alias).getAlias();
    		model.addAttribute("supervisor", iEmployeeLookup.getEmployeeByAlias(newAlias));
    		model.addAttribute("employeeList", iEmployeeLookup.getDirectReports(newAlias));
    	} else {
    		model.addAttribute("supervisor", iEmployeeLookup.getEmployeeByAlias(alias));
    		model.addAttribute("employeeList", iEmployeeLookup.getDirectReports(alias));
    	}
		
		return "orgChart";
	}
    
    @RequestMapping("/mapPage/{cubicle}")
    public String mapPage(Model model, @PathVariable String cubicle) {
    	model.addAttribute("cubicle", cubicle);
    	return "mapPage";
    }
}
