package com.project.employeemanagementapi.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeemanagementapi.InternationalizationMessageBean;

@RestController // handling Http Requests
@RequestMapping("/api")
public class InternationalizationMessageController {

	@Autowired
	private MessageSource messagesource;

	@GetMapping("/welcome-message")
	public String helloworld() {
		return "Welcome Employees !";
	}

	@GetMapping("/welcome-message-bean")
	public InternationalizationMessageBean helloworldbean() {
		return new InternationalizationMessageBean("Welcome Employees!");
	}

	@GetMapping("/hello-world-internalization")
	public String helloworldInternalizaton(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messagesource.getMessage("welcome.message", null, locale);
	}

	
}
