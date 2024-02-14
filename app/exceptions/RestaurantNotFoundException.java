package com.app.exceptions;

public class RestaurantNotFoundException  extends RuntimeException{
	
	public RestaurantNotFoundException(String mesg) {
		super(mesg);
	}


}
