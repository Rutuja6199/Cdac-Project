package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.global.GlobalData;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EmailSenderService;

@Controller
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	EmailSenderService emailService;
	
	@GetMapping("/login")
	public String login()
	{
		GlobalData.cart.clear();
		return "login";
	}
	

	@GetMapping("/register")
	public String registerGet()
	{
		return "register";
	}
	
	
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		int r=user.getRole();
		List<Role> roles= new ArrayList<>();
		roles.add(roleRepository.findById(r).get());
		user.setRoles(roles);
		if(userRepository.save(user) != null) {
			emailService.sendSimpleEmail(user.getEmail(), 
					"Dear "+user.getFirstName()+" "+user.getLastName()+" ,\n\n"
					+ "You are sucessfully registered to E-ART Heritage!!!", "E-ART Heritage");
		}
		request.login(user.getEmail(), password);
		return "redirect:/login";
	}
	
	
	
	

	
	
}
