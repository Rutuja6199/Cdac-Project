package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.example.demo.model.Role;

import lombok.Data;

@Data
public class userDTO {
private Integer id;

	private String firstName;
	private String lastName;
	

	private String email;
	
	
	private String password;
	private int role;
	

	private List<Role> roles;
}
