package com.example.customermanagement.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.customermanagement.CustomerManagementSystemApplication;
import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;

public interface ICustomerService {
	
	static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
  public default String ServiceLog() {
	logger.info("this is a customer management entity file ");
      logger.warn("this is a warn message");
      logger.error("this is an error message");
	return "ServiceLog";
	}
public List<Customer> getAllCustomers();
		
public Customer getCustomer(Integer cid);

public Customer addCustomer(Customer customer);

public String healthCheck(Integer cid);

public void delete(Integer id);
		

	}


