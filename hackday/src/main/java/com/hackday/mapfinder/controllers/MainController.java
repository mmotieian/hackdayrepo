package com.hackday.mapfinder.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/")
	public String doSomething() {

		return "Hack Day Testing.";
	}

}
