package com.example.customermanagement.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.customermanagement.CustomerManagementSystemApplication;
import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<CustomerDto,Integer> {

	static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
	default String RepositoryLog() {
	logger.info("this is a customer management repository file ");
	return "RepositoryLog";
	}
	
	CustomerDto save(Customer customer);
}
