package com.example.customermanagement.exception;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException()
	{
		
	}
	
	public CustomerNotFoundException(String msg) {
		super(msg);
	}

}
