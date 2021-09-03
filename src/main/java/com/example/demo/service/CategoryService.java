package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categories;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Categories> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public void addCategory(Categories category) {
		categoryRepository.save(category);
	}
	
	public void removeCategoryById(int id)
	{
		categoryRepository.deleteById(id);
	}
	
	public Optional<Categories> getCategoryById(int id)
	{
		return categoryRepository.findById(id);
	}
}
