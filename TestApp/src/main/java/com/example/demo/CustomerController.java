package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(path = "customers/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Customer get(@PathVariable Long id) {

		return customerRepository.findById(id).orElse(null);
	}
}
