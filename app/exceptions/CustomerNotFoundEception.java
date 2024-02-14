package com.app.exceptions;

public class CustomerNotFoundEception extends RuntimeException {
	public CustomerNotFoundEception(String mesg) {
		super(mesg);
	}
}
