package com.example.customermanagement.controller;

	import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.InvalidFieldException;
import com.example.customermanagement.service.ICustomerService;

	

	@RequestMapping(value="/customer")
	@RestController
	@CrossOrigin(value="*")
	public class CustomerController {
		
		@Autowired
		private ICustomerService service;
		
		private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	    @RequestMapping("/")
	    String controller(){
	        logger.debug("This is a debug message");
	        logger.info("This is a customer management controller layer");
	        logger.warn("This is a warn message");
	        logger.error("This is an error message");
	        return "controller";
	    }
		@GetMapping(value="/getAll")
		public ResponseEntity<List<Customer>> getAllCustomers()
		{
			List<Customer> getAllCustomers=service.getAllCustomers();
			return new ResponseEntity<>(getAllCustomers,HttpStatus.OK);
		}
		
		@GetMapping(value="/{cid}")
		public ResponseEntity<Customer> getCustomer(@PathVariable Integer cid)
		{
			Customer customer=service.getCustomer(cid);
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
		
		@PostMapping(value="/save")
		public ResponseEntity<Customer> savecustomer(@Valid @RequestBody Customer customer)
		{
		Customer savecustomer = service.addCustomer(customer);
		logger.info("saved details");
		
		 if(customer.getCity()==null) {
			 throw new InvalidFieldException("City is required");
		 }
		 return new ResponseEntity<Customer>(savecustomer, HttpStatus.CREATED);
		}
		
		@ExceptionHandler
		public String handleInvalidFieldException(InvalidFieldException exception) {
			return exception.getMessage();
		}
		
		
		@DeleteMapping("/customer/{id}")
		public void delete(@PathVariable Integer id) {
			 service.delete(id);
		}

	}



