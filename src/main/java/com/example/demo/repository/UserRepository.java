package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	Optional<User> findUserByEmail(String email);
	
//	List<User> findAllByRole_Id(int id);

	//List<Product> findAllByUser_Id(int id);
}
