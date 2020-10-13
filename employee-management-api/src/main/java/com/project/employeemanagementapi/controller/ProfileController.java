package com.project.employeemanagementapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ProfileController {

	@Value("${starting.message}")
	private String message;


	@GetMapping("/starting-message")
	public String getDefaultLevel() {
		return message;
	}

}
