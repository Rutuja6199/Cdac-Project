package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
@Service
public class UserService {

	
	
	@Autowired
	UserRepository userRepository;
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	
	public Optional<User> getUserById(int id)
	{
		return userRepository.findById(id);
	}
//	public List<User> getAllUserByCategoryId(int id)
//	{
//		return userRepository.findAllByRole_Id(id);
//	}
	
	
}
