package com.lcp.app.service;

import java.util.List;

import com.lcp.app.entity.Customer;

public interface CustomerService {

	
	Customer createCustomer( Customer customer);
	
	Customer getCustomerById(Long id);
	
	List<Customer> getAllCustomers();
	
	Customer updateCustomer(Customer customer, Long id);
	
	Customer deleteCustomer(Long id);
	
	List <Customer> getCustomerByName(String name);
	
	List <Customer> getCustomerByLastName(String name);
	
	
}
