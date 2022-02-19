package com.example.customermanagement.bo;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.customermanagement.CustomerManagementSystemApplication;
import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;

public interface ICustomerBO {
	
	static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
  public default String ServiceLog() {
	logger.info("this is a customer management bo file ");
     
	return "ServiceLog";
	}
public List<CustomerDto> getAllCustomers();
		
public CustomerDto getCustomer(Integer cid);

public CustomerDto addCustomer(CustomerDto customer);

public String healthCheck(Integer cid);

public void delete(Integer id);
		

	}


