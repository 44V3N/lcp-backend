package com.lcp.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lcp.app.entity.Category;

public interface CategoryRepository extends CrudRepository < Category, Long > {

	List<Category> findByName(String name);

	Category findById(long category_id);
}
