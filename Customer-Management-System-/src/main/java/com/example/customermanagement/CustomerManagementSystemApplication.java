package com.example.customermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CustomerManagementSystemApplication {
	private static final Logger logger = LoggerFactory.getLogger(CustomerManagementSystemApplication.class);
	public static void main(String[] args) {
		logger.info("this is a customer management spring boot application ");
	      logger.warn("this is a warn message");
	      logger.error("this is an error message");
		SpringApplication.run(CustomerManagementSystemApplication.class, args);
	}

}
