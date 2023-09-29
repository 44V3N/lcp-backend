package com.lcp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.lcp.app.entity.Customer;
import com.lcp.app.service.CustomerService;


@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public  ResponseEntity< Customer > createCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED); // Status 201
	}
	
	@PostMapping("login")
	public  ResponseEntity< Customer > loginCustomer(@RequestBody Customer customer) {
		Customer existingCustomer = customerService.loginCustomer(customer.getEmail(), customer.getPassword());
		return new ResponseEntity<>(existingCustomer, HttpStatus.OK); // Status 200
	}
	
	@GetMapping("{id}")
	public ResponseEntity< Customer > getCustomerById(@PathVariable Long id){
		Customer customer = customerService.getCustomerById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK); // Status 200
	}
	
	@GetMapping
	public ResponseEntity< List<Customer> > getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<>( customers, HttpStatus.OK );
	}
	
	@PutMapping("{id}")
	public ResponseEntity< Customer > updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
		Customer existingCustomer = customerService.updateCustomer(customer, id);
		return new ResponseEntity<>(existingCustomer, HttpStatus.OK); // Status 200
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity< Customer > deleteCustomer(@PathVariable Long id){
		Customer customer = customerService.deleteCustomer(id);
		return new ResponseEntity<>(customer, HttpStatus.OK); // Status 200
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity< List <Customer> > getCustomerByName(@PathVariable String name){
		List <Customer> customer = customerService.getCustomerByName(name);
		return new ResponseEntity<>(customer, HttpStatus.OK); // Status 200
	}
	
	@GetMapping("lastname/{name}")
	public ResponseEntity< List <Customer> > getCustomerByLastName(@PathVariable String name){
		List <Customer> customer = customerService.getCustomerByLastName(name);
		return new ResponseEntity<>(customer, HttpStatus.OK); // Status 200
	}
	
	
}
