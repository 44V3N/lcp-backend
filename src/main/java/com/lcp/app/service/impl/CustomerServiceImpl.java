package com.lcp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> Stashed changes
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
       return saveCustomer(customer);
    
    }
<<<<<<< Updated upstream

    public Customer saveCustomer(Customer customer) {
       String encryptedPassword = bcrypt.encode(customer.getPassword());
       customer.setPassword(encryptedPassword);
       return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
       return customerRepository.findById(id)
             .orElseThrow( ()-> new IllegalStateException("Customer does not exist with id " + id) );
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
=======
    
    public Customer saveCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
       return customerRepository.findById(id)
             .orElseThrow( ()-> new IllegalStateException("Customer does not exist with id " + id) );
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
//       String encryptedPassword = bcrypt.encode(customer.getPassword());
//       existingCustomer.setPassword(encryptedPassword);
       return saveCustomer( existingCustomer );
    }

    @Override
    public Customer deleteCustomer(Long id) {
       Customer existingCustomer = getCustomerById(id);
       customerRepository.delete(existingCustomer);
       return existingCustomer;
    }

//    BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
>>>>>>> Stashed changes


    @Override
    public Customer deleteCustomer(Long id) {
       Customer existingCustomer = getCustomerById(id);
       customerRepository.delete(existingCustomer);
       return existingCustomer;
    }

    BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
}