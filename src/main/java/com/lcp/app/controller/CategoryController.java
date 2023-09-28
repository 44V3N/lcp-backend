package com.lcp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lcp.app.entity.Category;
import com.lcp.app.service.CategoryService;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public  ResponseEntity< Category > createCategory(@RequestBody Category category) {
		Category newCategory = categoryService.createCategory(category);
		return new ResponseEntity<>(newCategory, HttpStatus.CREATED); // Status 201
	}
	
	@GetMapping("{id}")
	public ResponseEntity< Category > getCategoryById(@PathVariable Long id){
		Category category = categoryService.getCategoryById(id);
		return new ResponseEntity<>(category, HttpStatus.OK); // Status 200
	}
	
	@GetMapping
	public ResponseEntity< List<Category> > getAllCategories(){
		List<Category> category = categoryService.getAllCategories();
		return new ResponseEntity<>( category, HttpStatus.OK );
	}
	
	@PutMapping("{id}")
	public ResponseEntity< Category > updateCategory(@PathVariable Long id,@RequestBody Category category){
		Category existingCategory = categoryService.updateCategory(category, id);
		return new ResponseEntity<>(existingCategory, HttpStatus.OK); // Status 200
	}
	
//	@DeleteMapping("{id}")
//	public ResponseEntity< Category > deleteCategory(@PathVariable Long id){
//		Category category = categoryService.deleteCategory(id);
//		return new ResponseEntity<>(category, HttpStatus.OK); // Status 200
//	}
	
}
