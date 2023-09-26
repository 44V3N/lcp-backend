package com.lcp.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.lcp.app.entity.Customer;

public interface CustomerRepository extends CrudRepository< Customer, Long>{
	
	List<Customer> findByName(String name);
	List<Customer> findByLastName(String name);
	Customer findById(long id);
	
}
