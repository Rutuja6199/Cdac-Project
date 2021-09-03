package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categories;
import com.example.demo.model.Role;

import com.example.demo.repository.RoleRepository;
@Service
public class RoleService {

	
	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	
	public Optional<Role> getRoleById(int id)
	{
		return roleRepository.findById(id);
	}
}
