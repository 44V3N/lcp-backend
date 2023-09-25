package com.lcp.app.repository;


import org.springframework.data.repository.CrudRepository;

import com.lcp.app.entity.Customer;

public interface CustomerRepository extends CrudRepository< Customer, Long>{


}
