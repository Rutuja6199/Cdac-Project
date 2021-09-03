package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id", referencedColumnName = "category_id")
	private Categories category;
	
	private double price;
	private String description;
	private Date date;
	private String imagename;
	private int stock;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, Categories category, double price, String description, Date date,
			String imagename, int stock,User user) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.date = date;
		this.imagename = imagename;
		this.stock = stock;
		this.user = user;
	}
	public Product(String name, Categories category, double price, String description, Date date, String imagename,
			int stock,User user) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.date = date;
		this.imagename = imagename;
		this.stock = stock;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", description="
				+ description + ", date=" + date + ", imagename=" + imagename + ", stock=" + stock + ", user=" + user
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name="vendor_id", referencedColumnName = "vendor_id")
//	private Vendor vendor;
/*
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, Categories category, double price, String description, Date date,
			String imagename, Vendor vendor) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.date = date;
		this.imagename = imagename;
		//this.vendor = vendor;
	}

	public Product(String name, Categories category, double price, String description, Date date, String imagename,
			Vendor vendor) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.date = date;
		this.imagename = imagename;
		//this.vendor = vendor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", description="
				+ description + ", date=" + date + ", imagename=" + imagename + "]";
	}

//	public Vendor getVendor() {
//		return vendor;
//	}
//
//	public void setVendor(Vendor vendor) {
//		this.vendor = vendor;
//	}

//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", description="
//				+ description + ", date=" + date + ", imagename=" + imagename + ", vendor=" + vendor + "]";
//	}
	*/
	
	
}
