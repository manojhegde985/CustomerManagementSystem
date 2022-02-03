 package com.example.customermanagement.BO;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.customermanagement.CustomerManagementSystemApplication;
import com.example.customermanagement.EO.CustomerEO;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.mapstruct.MapstructMapper;
import com.example.customermanagement.repository.ICustomerRepository;





@Component
public class CustomerBO implements ICustomerBO{
@Autowired
private CustomerEO repository;
private MapstructMapper mapstruct;

private static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
public String ServiceLog() {
logger.info("this is a customer management entity file ");
logger.warn("this is a warn message");
logger.error("this is an error message");
return "ServiceLog";
}

@Autowired
public CustomerBO(
MapstructMapper mapstruct,
CustomerEO repository
)
{
this.mapstruct = mapstruct;
this.repository= repository;
}

public List<Customer> getAllCustomers() {
	List<Customer> allCustomers=repository.getAllCustomers();
	System.out.println("Getting data from DB :" +allCustomers);
	return allCustomers;
}

public Customer getCustomer(Integer cid) {
return repository.getCustomer( cid);

}

public Customer addCustomer(Customer customer) {

return repository.addCustomer( mapstruct.customerToCustomerGetdto(customer));
}


public void delete(Integer id) {

repository.delete(id);
}



}
