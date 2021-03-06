package com.hackday.mapfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.hackday")
@EnableAutoConfiguration
public class HackdayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackdayApplication.class, args);
	}
}
