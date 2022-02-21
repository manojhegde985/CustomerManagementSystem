package com.example.customermanagement.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerAdvice {
	  @ExceptionHandler(CustomerNotFoundException.class)
	    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException){
	        return new ResponseEntity<String>("User not found with given id", HttpStatus.BAD_REQUEST);

	    }
	    @ExceptionHandler(NoRecordFoundException.class)
	    public ResponseEntity<String> handleNoRecordFoundException    (NoRecordFoundException noRecordFoundException){
	        return new ResponseEntity<String>("No users found",HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(ServiceException.class)
	    @Validated
	    public ResponseEntity<String> handleServiceException    (ServiceException serviceException){
	        return new ResponseEntity<String>("No users found" ,HttpStatus.BAD_REQUEST);
	    }
}
