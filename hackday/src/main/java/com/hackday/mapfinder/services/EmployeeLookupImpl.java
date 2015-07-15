/**
 * 
 */
package com.hackday.mapfinder.services;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.hackday.mapfinder.model.EmployeeModel;

import scala.annotation.meta.getter;

/**
 * @author FFSY
 *
 */
public class EmployeeLookupImpl implements IEmployeeLookup {
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hackday.mapfinder.services.IEmployeeLookup#doLookup()
	 */
	
	
	
	@Override
	public List<EmployeeModel> lookupEmployee(String searchTerm) {
		
		String SQL = "SELECT * FROM EMPLOYEE WHERE upper(firstName) = '" + searchTerm.toUpperCase() + "' OR upper(lastName) = '" + 
				searchTerm.toUpperCase() + "' OR upper(alias) = '" + searchTerm.toUpperCase() + "' OR upper(cubicle) = '" + searchTerm.toUpperCase() + "'";
		List<EmployeeModel> empList = (List<EmployeeModel>) jdbcTemplate.query(SQL,new EmployeeMapper());

		return empList;

	}
	

	@Override
	public void setNameParameterJdbcTemplate(DataSource db) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(db);
		// TODO Auto-generated method stub
		
	}



	public List<EmployeeModel> getEmployees() {
		String SQL = "SELECT * FROM EMPLOYEE";
		List<EmployeeModel> empList = (List<EmployeeModel>) jdbcTemplate.query(SQL,new EmployeeMapper());
		return empList;
	}

	@Override
	public EmployeeModel getEmployeeByAlias(String alias) {
		String SQL = "SELECT * FROM EMPLOYEE WHERE alias = :empAlias";
		SqlParameterSource namedParamters = new MapSqlParameterSource("empAlias", alias);
		
		EmployeeModel employeeModel = (EmployeeModel) jdbcTemplate.queryForObject(SQL, namedParamters, new EmployeeMapper());
		
		return employeeModel;
		
	}


	@Override
	public List<EmployeeModel> getDirectReports(String alias) {
		String SQL = "SELECT * FROM EMPLOYEE WHERE supervisorAlias = '" + alias + "'";
		List<EmployeeModel> empList = (List<EmployeeModel>) jdbcTemplate.query(SQL,new EmployeeMapper());
		return empList;
	}
	
	@Override
	public EmployeeModel getEmployeeSupervisorByAlias(String alias) {
		String SQL = "SELECT * FROM EMPLOYEE WHERE alias = (SELECT supervisorAlias FROM EMPLOYEE WHERE alias = :empAlias)";
		SqlParameterSource namedParamters = new MapSqlParameterSource("empAlias", alias);
		
		EmployeeModel employeeModel = (EmployeeModel) jdbcTemplate.queryForObject(SQL, namedParamters, new EmployeeMapper());
		
		return employeeModel;
	}

}
