/**
 * 
 */
package com.hackday.mapfinder.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FFSY
 *
 */
@Configuration
public class ApplicationConfig {

	@Bean
	public IEmployeeLookup iEmployeeLookup() {
		return new EmployeeLookupImpl();
	}
}
