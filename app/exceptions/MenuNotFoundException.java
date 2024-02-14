package com.app.exceptions;

public class MenuNotFoundException extends RuntimeException {
	public MenuNotFoundException(String mesg) {
		super(mesg);
	}
	
}
