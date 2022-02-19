package com.example.customermanagement.controller;

	import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.mapstruct.MapstructMapper;
import com.example.customermanagement.service.ICustomerService;
import com.example.customermanagement.util.CustomerConstant;

	
    @ControllerAdvice
	@RequestMapping(value="/customer")
	@RestController
	
    
	public class CustomerController {
		
		@Autowired
		private ICustomerService service;
		@Autowired
		private MapstructMapper mapstruct;
		private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	    @RequestMapping("/")
	    String controller(){
	        logger.info("This is a customer management controller layer");
	        return "controller";
	    }
		@GetMapping(value=CustomerConstant.GET)
		public ResponseEntity<List<Customer>> getAllCustomers()
		{
			List<Customer> getAllCustomers=service.getAllCustomers();
			
			return new ResponseEntity<>(getAllCustomers,HttpStatus.OK);
		}
		
		@GetMapping(value=CustomerConstant.GETBYID)
		public ResponseEntity<Customer> getCustomer(@PathVariable Integer cid)
		{
			Customer customer=service.getCustomer(cid);
			if(customer.getCid()==cid) {
				return new ResponseEntity<Customer>(customer,HttpStatus.OK);
			}
			else {
				throw new CustomerNotFoundException("Customer not found");
			}
		}
		
		
		@PostMapping(value=CustomerConstant.SAVE)
		public ResponseEntity<Customer> savecustomer( @RequestBody Customer customer)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(service.addCustomer(customer));
		}
		
		
		@DeleteMapping("/customer/{id}")
		public void delete(@PathVariable Integer id) {
			 service.delete(id);
		}
		
		@GetMapping(value =CustomerConstant.HEALTH)
		public ResponseEntity<String> healthcheck(@PathVariable Integer cid){
		String str = service.healthCheck(cid);
		logger.info("HealthCheck Successful");
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
		}

	}



