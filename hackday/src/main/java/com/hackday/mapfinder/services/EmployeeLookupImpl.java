/**
 * 
 */
package com.hackday.mapfinder.services;

import java.util.ArrayList;
import java.util.List;

import com.hackday.mapfinder.model.EmployeeModel;

/**
 * @author FFSY
 *
 */

public class EmployeeLookupImpl implements IEmployeeLookup {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hackday.mapfinder.services.IEmployeeLookup#doLookup()
	 */
	@Override
	public List<EmployeeModel> doLookup() {

		System.out.println("Employee Lookup in EmployeeLookupImpl");

		// Hard-coded values of an employee
		// TODO need to dynaimcally populate
		List<EmployeeModel> empList = new ArrayList<>();
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setfName("John");
		employeeModel.setlName("Smith");
		employeeModel.setTitle("Systems Analyst");
		employeeModel.setCubicle("1.9111");
		employeeModel.setPhoneNumer("972-123-4567");

		empList.add(employeeModel);

		return empList;

	}

}
