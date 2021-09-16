package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Categories;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;


@Controller
public class AdminController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}
	
	@GetMapping("/admin/categories")
	public String getCat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCatAdd(Model model) {
		model.addAttribute("category",new Categories());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postCatAdd(@ModelAttribute("category") Categories categories) {
		categoryService.addCategory(categories);
		return "redirect:/admin/categories";
	}
	
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat(@PathVariable int id)
	{
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
		
	}
	
	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id,Model model) {
		Optional<Categories> category = categoryService.getCategoryById(id);
		if(category.isPresent())
		{
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		} else
			return "404";
				
	}
	
	
	@GetMapping("/admin/users")
	public String getUser(Model model) {
		model.addAttribute("role",roleService.getAllRoles());
		model.addAttribute("user",userService.getAllUser());
		return "users";
	}
	
	@GetMapping("/users/roles/{id}")
	public String getUserByRole(Model model,@PathVariable int id) {
		model.addAttribute("role",roleService.getAllRoles());
	 model.addAttribute("user",userService.getUserById(id));
		return "users";
	}
	
}
