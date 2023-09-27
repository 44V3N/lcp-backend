package com.lcp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcp.app.entity.Category;
import com.lcp.app.repository.CategoryRepository;
import com.lcp.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category createCategory(Category category) {
		return saveCategory(category);
	
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Category does not exist with id " + id) );
	}
	
	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) categoryRepository.findAll();
	}
	
	@Override
	public Category updateCategory(Category category, Long id) {
		Category existingCategory = getCategoryById(id);
		existingCategory.setName(  category.getName()   );
		existingCategory.setUrlCategory(  category.getUrlCategory()   );
		return saveCategory( existingCategory );
	}
	
//	@Override
//	public Category deleteCategory(Long id) {
//		Category existingCategory = getCategoryById(id);
//		categoryRepository.delete(existingCategory);
//		return existingCategory;
//	}

}
