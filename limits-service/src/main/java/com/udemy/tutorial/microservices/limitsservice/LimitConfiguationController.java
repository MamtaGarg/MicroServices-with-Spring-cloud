package com.udemy.tutorial.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.tutorial.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitConfiguationController {

	@Autowired
	private Configuration configuration; 

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

}
