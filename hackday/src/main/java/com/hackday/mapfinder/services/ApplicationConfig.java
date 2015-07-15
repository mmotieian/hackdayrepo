/**
 * 
 */
package com.hackday.mapfinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author FFSY
 *
 */
@Configuration
public class ApplicationConfig {
	
	@Autowired
	DataSource dataSource;
 
	
	@Bean
	public IEmployeeLookup iEmployeeLookup() {
		EmployeeLookupImpl employeeLookup = new EmployeeLookupImpl();
		employeeLookup.setNameParameterJdbcTemplate(dataSource);
		
		return employeeLookup;
	}
	
	@Bean
	public static DataSource dataSource() {
 
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
			.addScript("create-db.sql")
			.addScript("insert-data.sql")
			.build();
		return db;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
}
