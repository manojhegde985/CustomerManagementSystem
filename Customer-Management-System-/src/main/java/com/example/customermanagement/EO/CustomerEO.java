package com.example.customermanagement.EO;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.customermanagement.CustomerManagementSystemApplication;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.mapstruct.MapstructMapper;
import com.example.customermanagement.repository.ICustomerRepository;





@Component
public class CustomerEO implements ICustomerEO{
@Autowired
private ICustomerRepository repository;
private MapstructMapper mapstruct;

private static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
public String ServiceLog() {
logger.info("this is a customer management entity file ");
logger.warn("this is a warn message");
logger.error("this is an error message");
return "ServiceLog";
}

@Autowired
public CustomerEO(
MapstructMapper mapstruct,
ICustomerRepository repository
)
{
this.mapstruct = mapstruct;
this.repository= repository;
}




public List<Customer> getAllCustomers() {
List<Customer> allCustomers=repository.findAll();
System.out.println("Getting data from DB :" +allCustomers);
return allCustomers;
}

public Customer getCustomer(Integer cid) {
return repository.findById(cid).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));

}

public Customer addCustomer(Customer customer) {

return repository.save( mapstruct.customerToCustomerGetdto(customer));
}




public void delete(Integer id) {

repository.deleteById(id);
}
}