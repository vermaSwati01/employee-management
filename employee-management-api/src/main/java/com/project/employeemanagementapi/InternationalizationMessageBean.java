package com.project.employeemanagementapi;

public class InternationalizationMessageBean  {

	
	private String message;
	public InternationalizationMessageBean(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HelloWordlBean [message=" + message + "]";
	}
	
	
	

}
