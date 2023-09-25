package com.lcp.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.lcp.app.entity.Category;

public interface CategoryRepository extends CrudRepository < Category, Long > {

}
