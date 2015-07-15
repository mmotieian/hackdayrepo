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

/**
 * @author FFSY
 *
 */
public class EmployeeLookupImpl implements IEmployeeLookup {
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	private List<EmployeeModel> employees = EmployeeLookupImpl.generateEmployees();
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hackday.mapfinder.services.IEmployeeLookup#doLookup()
	 */
	
	
	
	@Override
	public List<EmployeeModel> lookupEmployee(String searchTerm) {
		
		String SQL = "SELECT * FROM EMPLOYEE WHERE firstName = '" + searchTerm + "' OR lastName = '" + searchTerm + "' OR alias = '" + searchTerm + "' OR cubicle = '" + searchTerm + "'";
		
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



	public void setEmployees(List<EmployeeModel> employees) {
		this.employees = employees;
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


	public static List<EmployeeModel> generateEmployees() {
		List<EmployeeModel> empList = new ArrayList<>();
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setFirstName("James");
		employeeModel.setLastName("Mellinger");
		employeeModel.setTitle("Systems Analyst");
		employeeModel.setCubicle("1-9111");
		employeeModel.setPhoneNumer("972-123-4567");
		employeeModel.setAlias("FFAA");
		
		EmployeeModel employeeModel2 = new EmployeeModel();
		employeeModel2.setFirstName("Bernardo");
		employeeModel2.setLastName("Rivera");
		employeeModel2.setTitle("Systems Analyst");
		employeeModel2.setCubicle("1.9111");
		employeeModel2.setPhoneNumer("972-123-4567");
		employeeModel2.setAlias("FFAB");

		EmployeeModel employeeModel3 = new EmployeeModel();
		employeeModel3.setFirstName("Elizabeth");
		employeeModel3.setLastName("Johnson");
		employeeModel3.setTitle("Systems Analyst");
		employeeModel3.setCubicle("1.9111");
		employeeModel3.setPhoneNumer("972-123-4567");
		employeeModel3.setAlias("FFAC");
		
		EmployeeModel employeeModel4 = new EmployeeModel();
		employeeModel4.setFirstName("Thomas");
		employeeModel4.setLastName("Matthew");
		employeeModel4.setTitle("Systems Analyst");
		employeeModel4.setCubicle("1.9111");
		employeeModel4.setPhoneNumer("972-123-4567");
		employeeModel4.setAlias("FFAD");
		
		EmployeeModel employeeModel5 = new EmployeeModel();
		employeeModel5.setFirstName("Muhammad");
		employeeModel5.setLastName("Najar");
		employeeModel5.setTitle("Systems Analyst");
		employeeModel5.setCubicle("1.9111");
		employeeModel5.setPhoneNumer("972-123-4567");
		employeeModel5.setAlias("FFAE");
		
		EmployeeModel employeeModel6 = new EmployeeModel();
		employeeModel6.setFirstName("Luke");
		employeeModel6.setLastName("Reardon");
		employeeModel6.setTitle("Manager");
		employeeModel6.setCubicle("1.9111");
		employeeModel6.setPhoneNumer("972-123-4567");
		employeeModel6.setAlias("FFAF");
		
		empList.add(employeeModel);
		empList.add(employeeModel2);
		empList.add(employeeModel3);
		empList.add(employeeModel4);
		empList.add(employeeModel5);
		empList.add(employeeModel6);
		
		return empList;
	}

}
