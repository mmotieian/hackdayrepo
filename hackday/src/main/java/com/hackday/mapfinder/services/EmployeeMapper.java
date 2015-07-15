package com.hackday.mapfinder.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hackday.mapfinder.model.EmployeeModel;

public class EmployeeMapper implements RowMapper {
	
	public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeModel employee = new EmployeeModel();
		employee.setAlias(rs.getString("alias"));
		employee.setFirstName(rs.getString("firstName"));
		employee.setLastName(rs.getString("lastName"));
		employee.setSupervisorAlias(rs.getString("supervisorAlias"));
		employee.setTitle(rs.getString("title"));
		employee.setCubicle(rs.getString("cubicle"));
		employee.setPhoneNumer(rs.getString("phoneNumber"));
		
		return employee;
	}

}
