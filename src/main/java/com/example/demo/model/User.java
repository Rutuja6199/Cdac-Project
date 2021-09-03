package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Entity
@Data
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty
	@Column(nullable = false)
	private String firstName;
	private String lastName;
	
	@Column(nullable = false, unique = true)
	@NotEmpty
	@Email(message="{errors.invalid_email}")
	private String email;
	
	
	private String password;
	private int role;
	
//	private String phone;
//	private String address;
//	
//	private Integer pincode;
//	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
			name= "user_role",
			joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn (name = "ROLE_ID", referencedColumnName = "ID")} 	
			)
	private List<Role> roles;


public User() {
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public Integer getPincode() {
//		return pincode;
//	}
//
//	public void setPincode(Integer pincode) {
//		this.pincode = pincode;
//	}

	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	
	public User(User user) {
		
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
//		this.phone = user.getPhone();
//		this.address = user.getAddress();
//		this.pincode = user.getPincode();
		this.roles = user.getRoles();
		this.role = user.getRole();
	}

	

	public User(Integer id, @NotEmpty String firstName, String lastName,
			@NotEmpty @Email(message = "{errors.invalid_email}") String email, String password, int role,
			List<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", roles=" + roles + "]";
	}


	

	
	
	
	
//	public User(Integer id, @NotEmpty String firstname, String lastname,
//			@Email(message = "{errors.invalid_email}") String email, @NotEmpty String password, @NotEmpty String phone,
//			@NotEmpty String address, @NotEmpty Integer pincode, List<Role> roles) {
//		super();
//		this.id = id;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.email = email;
//		this.password = password;
//		this.phone = phone;
//		this.address = address;
//		this.pincode = pincode;
//		this.roles = roles;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
//				+ ", password=" + password + ", phone=" + phone + ", address=" + address + ", pincode=" + pincode + "]";
//	}

	
	
	
	
	
}
