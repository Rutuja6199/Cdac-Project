package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Categories;
import com.example.demo.model.Product;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;


@Controller
public class VendorController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping("/vendor")
	public String adminHome() {
		return "vendorHome";
	}
	

	@GetMapping("/vendor/products")
	public String products(Model model)
	{
		model.addAttribute("products", productService.getAllProducts());
		return "products";
		
	}
	

	@GetMapping("/vendor/products/add")
	public String productsAddGet(Model model)
	{
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.getAllCategory());
		return "productsAdd";
		
	}
	
	
	
	@PostMapping("vendor/products/add")
	public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO,@RequestParam("productImage")MultipartFile file,@RequestParam("imgName")String imgName) throws IOException {
		
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getCategoryById(productDTO.getCategory_id()).get());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setDate(productDTO.getDate());
		product.setImagename(productDTO.getImageName());
		product.setStock(productDTO.getStock());
		
		String imageUUID;
		if(!file.isEmpty())
		{
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		} else {
			imageUUID = imgName;
		}
		product.setImagename(imageUUID);
		productService.addProduct(product);
		return "redirect:/vendor/products";
	}
	
	
	
	

	@GetMapping("/vendor/product/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		productService.removeProductById(id);
		
		return "redirect:/vendor/products";
		
	}
	
	@GetMapping("/vendor/product/update/{id}")
	public String updateProduct(@PathVariable int id,Model model) {
		Product product = productService.getProductById(id).get();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategory_id(product.getCategory().getId());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setDate(product.getDate());
		productDTO.setImageName(product.getImagename());
		productDTO.setStock(product.getStock());
		
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("productDTO",productDTO);
		
			return "productsAdd";
		
				
	}
	
	@GetMapping("/registervendor")
	public String registerVendorGet()
	{
		return "registervendor";
	}
	

	@PostMapping("/registervendor")
	public String registervendorPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles= new ArrayList<>();
		roles.add(roleRepository.findById(3).get());
		user.setRoles(roles);
		userRepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
	}
	
	
}
