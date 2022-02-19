package com.example.customermanagement.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customermanagement.CustomerManagementSystemApplication;
import com.example.customermanagement.bo.CustomerBO;
import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.exception.NoRecordFoundException;
import com.example.customermanagement.mapstruct.MapstructMapper;
import com.example.customermanagement.repository.ICustomerRepository;





@Service
public class CustomerService implements ICustomerService{
@Autowired
private CustomerBO bo;
@Autowired
private MapstructMapper mapstruct;

private static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
public String ServiceLog() {
logger.info("this is a customer management service layer ");

return "ServiceLog";
}



@Override
public List<Customer> getAllCustomers()throws   ServiceException {
List<Customer> allCustomers = mapstruct.customerDtoToCustomerList(bo.getAllCustomers());
try{if(!allCustomers.isEmpty()) {
return allCustomers;
}
else throw new NoRecordFoundException("list is empty");
}
catch(NoRecordFoundException e) {
    logger.error(e.getMessage());
    throw new ServiceException(e.getMessage());
}
}

@Override
public Customer getCustomer(Integer cid) {
	
return mapstruct.customerDtoToCustomer(bo.getCustomer(cid));
	
     }

@Override
public Customer addCustomer(Customer customer) {
	try {
		CustomerDto customerdto=bo.addCustomer(mapstruct.customerToCustomerDto(customer));
	return mapstruct.customerDtoToCustomer((customerdto));
}catch(Exception e){
	 logger.error("could not add customer");
	    throw new ServiceException("could not add customer" + e);
}
}

@Override
public void delete(Integer id) {

bo.delete(id);
}

public String healthCheck(Integer cid) {
	return bo.healthCheck(cid);
}


}





