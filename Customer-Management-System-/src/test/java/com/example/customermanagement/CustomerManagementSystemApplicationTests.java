package com.example.customermanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.repository.ICustomerRepository;
import com.example.customermanagement.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class CustomerManagementSystemApplicationTests {

	@Autowired
	private CustomerService service;
	

	 @MockBean
	private ICustomerRepository repository;
	 
	/* @Autowired
	 private MockMvc mockMvc;

	 @Autowired
	 private WebApplicationContext context;
	 
	 ObjectMapper om = new ObjectMapper();
*/
		@Before
		public void init() {
			MockitoAnnotations.initMocks(this);
		}

	@Test
	public void getAllCustomersTest() {
	when(repository.findAll()).thenReturn(Stream
	.of(new CustomerDto(1,"Manoj","Bangalore","manoj@gmail.com"),
	new CustomerDto(2,"John","Bangalore","john@gmail.com")).collect
	(Collectors.toList()));
	assertEquals(2,service.getAllCustomers().size());
	}
	

	
	
	@Test
	public void addCustomerTest() {
		CustomerDto customer = new CustomerDto(1,"Manoj","Bangalore","manoj@gmail.com");
		when(repository.save(Mockito.any(CustomerDto.class)))
		.thenAnswer(i -> i.getArguments()[0]);
		}
	
	   
		@Test
		public void  getCustomer(){
		CustomerDto customer = new CustomerDto();
		customer.setCid(8);
		when(repository.findById(customer.getCid())).thenReturn(Optional.of(customer));
		Customer expected = (Customer) service.getCustomer(customer.getCid());
	//	assertThat(expected).isSameAs(customer);
		verify(repository).findById(customer.getCid());
		}
		
		
	/*	@Test
		public void addCustomer() throws Exception
		{
		Customer customer = new Customer();
		customer.setCid(12);
		customer.setCname("Manoj");
		customer.setCity("Pune");
		customer.setEmail("manoj@gmail.com");

		String jsonRequest = om.writeValueAsString(customer);
		mockMvc.perform(post("/customer/save")
		.content(jsonRequest)
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status()
		.isCreated());

		}
		
		@Test
         public void getAllCustomer() throws Exception
         {
         Customer customer = new Customer();
		customer.setCid(12);
		customer.setCname("Manoj");
		customer.setCity("Pune");
		customer.setEmail("manoj@gmail.com");
          mockMvc.perform(get("/customer/getAll")
          .contentType(MediaType.APPLICATION_JSON_VALUE))
          .andDo(print())
          .andExpect(status()
          .isOk());
          }

	*/
	
}
