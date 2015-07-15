/**
 * 
 */
package com.hackday.mapfinder.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.hackday.mapfinder.model.EmployeeModel;

/**
 * @author FFSY
 *
 */
public interface IEmployeeLookup {

	public List<EmployeeModel> lookupEmployee(String searchTerm);
	public EmployeeModel getEmployeeByAlias(String alias);
	public void setNameParameterJdbcTemplate(DataSource db);
	public List<EmployeeModel> getDirectReports(String alias);
	public EmployeeModel getEmployeeSupervisorByAlias(String alias);
}
