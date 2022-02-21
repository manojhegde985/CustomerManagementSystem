package com.example.customermanagement.test_template;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import com.example.customermanagement.controller.CustomerController;

@RestClientTest(CustomerController.class)
public class UserControllerTest {

	@Autowired 
	private CustomerController customer;
	
	@Autowired
	private MockRestServiceServer mockRestServiceServer;
	
	@Test
	public void shouldReturnRandomQuote() {
		String result="""
			{
					  "success": "string",
					  "contents": {
					    "quotes": [
					      {
					        "author": "string",
					        "quote": "string",
					        "tags": [
					          "string"
					        ],
					        "id": "string",
					        "image": "string",
					        "length": 0
					      }
					    ]
					  }
					}
				""";
		this.mockRestServiceServer
		.expect(MockRestRequestMatchers.requestTo("/customer"))
		.andRespond(MockRestResponseCreators.withSuccess(result,MediaType.APPLICATION_JSON));
		
		String response=customer.toString();
		assertEquals("John",response);
	}
}
*/