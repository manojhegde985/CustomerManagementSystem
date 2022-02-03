package com.example.customermanagement.mapstruct;

import org.springframework.stereotype.Component;
import com.example.customermanagement.entity.Customer;



@Component
public class MapstructMapperImpl implements MapstructMapper {



@Override
public Customer customerToCustomerGetdto(Customer customer) {
if ( customer == null ) {
return null;

}
Customer customerdto = new Customer();



customerdto.setCid( customer.getCid());
customerdto.setEmail( customer.getEmail());
customerdto.setCname( customer.getCname());
customerdto.setCity( customer.getCity());




return customerdto;
}

}

