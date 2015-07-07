/**
 * 
 */
package com.hackday.mapfinder.services;

import org.springframework.stereotype.Component;

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
	public void doLookup() {
		System.out.println("Employee Lookup in EmployeeLookupImpl");

	}

}
