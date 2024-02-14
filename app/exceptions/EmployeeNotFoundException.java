package com.app.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String mesg) {
		super(mesg);
	}
}
