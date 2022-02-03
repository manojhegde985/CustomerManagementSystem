package com.example.customermanagement.mapstruct;

import org.mapstruct.Mapper;



import com.example.customermanagement.entity.Customer;



@Mapper(componentModel="spring")
public interface MapstructMapper {
Customer customerToCustomerGetdto(Customer customer);

}