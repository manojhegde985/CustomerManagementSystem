package com.example.customermanagement.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;



@Mapper(componentModel="spring")
public interface MapstructMapper {
CustomerDto customerToCustomerDto(Integer cid);

CustomerDto customerToCustomerDto(Customer customer);

Customer customerDtoToCustomer(CustomerDto customer);

List<CustomerDto> customerToCustomerDtoList(List<Customer> list);

List<Customer> customerDtoToCustomerList(List<CustomerDto> list);
}