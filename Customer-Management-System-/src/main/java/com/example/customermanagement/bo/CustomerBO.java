 package com.example.customermanagement.bo;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.customermanagement.CustomerManagementSystemApplication;
import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.eo.CustomerEO;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.mapstruct.MapstructMapper;
import com.example.customermanagement.repository.ICustomerRepository;





@Component
public class CustomerBO implements ICustomerBO{
@Autowired
private CustomerEO eo;
@Autowired
private MapstructMapper mapstruct;


private static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
public String ServiceLog() {
logger.info("this is a customer management bo file ");
return "ServiceLog";
}


public List<CustomerDto> getAllCustomers() {
	List<CustomerDto> allCustomers=eo.getAllCustomers();
	return allCustomers;
}

public CustomerDto getCustomer(Integer cid) {
return eo.getCustomer( cid);

}

@Override
public CustomerDto addCustomer(CustomerDto customer) {
	return eo.addCustomer(customer);
}

public void delete(Integer id) {

eo.delete(id);
}

public String healthCheck(Integer cid) {
	return eo.healthCheck(cid);
}



}
