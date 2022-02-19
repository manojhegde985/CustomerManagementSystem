package com.example.customermanagement.eo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.customermanagement.CustomerManagementSystemApplication;
import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.mapstruct.MapstructMapper;
import com.example.customermanagement.repository.ICustomerRepository;





@Component
public class CustomerEO implements ICustomerEO{
@Autowired
private ICustomerRepository repository;
@Autowired
private MapstructMapper mapstruct;

private static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
public String ServiceLog() {
logger.info("this is a customer management entity file ");
logger.warn("this is a warn message");
logger.error("this is an error message");
return "ServiceLog";
}




public List<CustomerDto> getAllCustomers() {
List<CustomerDto> allCustomers=repository.findAll();
return allCustomers;
}

public CustomerDto getCustomer(Integer cid) {
return repository.findById(cid).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));

}

@Override
public CustomerDto addCustomer(CustomerDto customer) {
	return repository.save(customer);
}

public void delete(Integer id) {

repository.deleteById(id);
}


@Override
public String healthCheck(Integer cid) {

java.util.Optional<CustomerDto> s = repository.findById(cid);
if(s.isPresent()) {
return ("HealthCheck-Success");
}
else {
return ("HealthCheck-Failure");
}
}


}
