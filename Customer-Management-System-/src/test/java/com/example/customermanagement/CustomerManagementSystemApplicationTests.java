package com.example.customermanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.repository.ICustomerRepository;
import com.example.customermanagement.service.CustomerService;

@SpringBootTest
class CustomerManagementSystemApplicationTests {

	@Autowired
	private CustomerService service;



	 @MockBean
	private ICustomerRepository repository;

	@Test
	public void getAllCustomersTest() {
	when(repository.findAll()).thenReturn(Stream
	.of(new Customer(1,"Manoj","Bangalore","manoj@gmail.com"),
	new Customer(2,"John","Bangalore","john@gmail.com")).collect
	(Collectors.toList()));
	assertEquals(2,service.getAllCustomers().size());
	}
	

	@Test
	public void addCustomerTest() {
		Customer customer = new Customer(1,"Manoj","Bangalore","manoj@gmail.com");
		when(repository.save(Mockito.any(Customer.class)))
		.thenAnswer(i -> i.getArguments()[0]);
		}
	
	
		
	    
		@Test
		public void  getCustomer(){
		Customer customer = new Customer();
		customer.setCid(8);
		when(repository.findById(customer.getCid())).thenReturn(Optional.of(customer));
		Customer expected = (Customer) service.getCustomer(customer.getCid());
		assertThat(expected).isSameAs(customer);
		verify(repository).findById(customer.getCid());
		}
	

}
