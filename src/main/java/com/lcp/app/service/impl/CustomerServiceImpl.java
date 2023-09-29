package com.lcp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lcp.app.entity.Customer;
import com.lcp.app.repository.CustomerRepository;
import com.lcp.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;
    
    @Override
    public Customer createCustomer(Customer customer) {
       Customer existingCustomer = getCustomerByEmail(customer.getEmail());
       if(existingCustomer != null) {
    	   throw new IllegalStateException("User with email" + customer.getEmail() + "already exists");
       }
       String encryptedPassword = bcrypt.encode(customer.getPassword());
       customer.setPassword(encryptedPassword);
       return saveCustomer(customer);
    }

    public Customer saveCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
       return customerRepository.findById(id)
             .orElseThrow( ()-> new IllegalStateException("Customer does not exist with id: " + id) );
    }
    
    @Override
    public Customer getCustomerByEmail(String email) {
       return customerRepository.findByEmail(email);
    }
    
    public List <Customer> getCustomerByName(String name) {
       List <Customer> existingCustomers = customerRepository.findByName(name);
             if( existingCustomers == null || existingCustomers.isEmpty()) {
                throw new IllegalStateException("User does not exist");
             }
             return existingCustomers;
    }
    
    public List <Customer> getCustomerByLastName(String name) {
       List <Customer> existingCustomers = customerRepository.findByLastName(name);
             if( existingCustomers == null || existingCustomers.isEmpty()) {
                throw new IllegalStateException("User does not exist");
             }
             return existingCustomers;
    }

    @Override
    public List<Customer> getAllCustomers() {
       return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
       Customer existingCustomer = getCustomerById(id);
       existingCustomer.setName(  customer.getName()   );
       existingCustomer.setLastName( customer.getLastName());
       existingCustomer.setLastName2( customer. getLastName2());
       existingCustomer.setSex( customer.getSex());
       existingCustomer.setBirthDate( customer.getBirthDate());
       existingCustomer.setEmail(customer.getEmail());
       existingCustomer.setPhonenumber( customer.getPhonenumber());
       String encryptedPassword = bcrypt.encode(customer.getPassword());
       existingCustomer.setPassword(encryptedPassword);
       return saveCustomer( existingCustomer );
    }

    @Override
    public Customer deleteCustomer(Long id) {
       Customer existingCustomer = getCustomerById(id);
       customerRepository.delete(existingCustomer);
       return existingCustomer;
    }
    
    public Customer loginCustomer(String email, String password) {
        Customer existingCustomer = getCustomerByEmail(email);
        if(existingCustomer != null) {
     	   if(bcrypt.matches(password, existingCustomer.getPassword())) {
     		   return existingCustomer;
     	   }
        }
        throw new IllegalStateException("User or Password Incorrect");
    }

    BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
}