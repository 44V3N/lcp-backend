package com.lcp.app.service;

import java.util.List;

import com.lcp.app.entity.Customer;

public interface CustomerService {

	
	Customer createCustomer( Customer customer);
	
	Customer getCustomerById(Long id);
	
	Customer getCustomerByEmail(String Email);
	
	List<Customer> getAllCustomers();
	
	Customer updateCustomer(Customer customer, Long id);
	
	Customer deleteCustomer(Long id);
	
	Customer loginCustomer(String email, String password);
	
	List <Customer> getCustomerByName(String name);
	
	List <Customer> getCustomerByLastName(String name);
	
	
}
