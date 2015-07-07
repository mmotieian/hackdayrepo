/**
 * 
 */
package com.hackday.mapfinder.services;

import java.util.List;

import com.hackday.mapfinder.model.EmployeeModel;

/**
 * @author FFSY
 *
 */
public interface IEmployeeLookup {

	public List<EmployeeModel> doLookup();
}
