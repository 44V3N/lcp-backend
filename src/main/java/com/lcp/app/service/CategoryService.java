package com.lcp.app.service;

import java.util.List;

import com.lcp.app.entity.Category;


public interface CategoryService {
	
	Category createCategory( Category category);
	
	Category getCategoryById(Long id);
	
	List<Category> getAllCategories();
	
	Category updateCategory(Category category, Long id);
	
	Category deleteCategory(Long id);
}
